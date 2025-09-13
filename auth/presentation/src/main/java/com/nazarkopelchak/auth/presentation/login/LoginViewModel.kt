package com.nazarkopelchak.auth.presentation.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nazarkopelchak.auth.domain.AuthRepository
import com.nazarkopelchak.auth.domain.UserDataValidator
import com.nazarkopelchak.auth.presentation.R
import com.nazarkopelchak.auth.presentation.textAsFlow
import com.nazarkopelchak.core.domain.util.DataError
import com.nazarkopelchak.core.domain.util.Result
import com.nazarkopelchak.core.presentation.ui.UiText
import com.nazarkopelchak.core.presentation.ui.asUiText
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val authRepository: AuthRepository,
    private val userDataValidator: UserDataValidator
): ViewModel() {

    var state by mutableStateOf(LoginState())
        private set

    private val eventChannel = Channel<LoginEvents>()
    val events = eventChannel.receiveAsFlow()

    init {
        combine(state.email.textAsFlow(), state.password.textAsFlow()) { email, password ->
            state = state.copy(
                canLogin = userDataValidator.isValidEmail(email.toString().trim()) && password.isNotEmpty()
            )
        }.launchIn(viewModelScope)
    }

    fun onAction(action: LoginAction) {
        when (action) {
            LoginAction.OnLoginClick -> login()
            LoginAction.OnTogglePasswordVisibility -> {
                state = state.copy(
                    isPasswordVisible = state.isPasswordVisible.not()
                )
            }
            else -> Unit
        }
    }

    private fun login() {
        viewModelScope.launch {
            state = state.copy(
                isLoggingIn = true
            )
            val result = authRepository.login(
                email = state.email.text.toString().trim(),
                password = state.password.text.toString()
            )
            state = state.copy(
                isLoggingIn = false
            )
            when(result) {
                is Result.Error -> {
                    if (result.error == DataError.Network.UNAUTHORIZED) {
                        eventChannel.send(
                            LoginEvents.Error(UiText.StringResource(R.string.error_email_password_incorrect))
                        )
                    } else {
                        eventChannel.send(
                            LoginEvents.Error(result.error.asUiText())
                        )
                    }
                }
                is Result.Success -> {
                    eventChannel.send(
                        LoginEvents.LoginSuccess
                    )
                }
            }
        }
    }
}