package com.nazarkopelchak.auth.presentation.register

import com.nazarkopelchak.core.presentation.ui.UiText

sealed interface RegisterEvent {
    data object RegistrationSuccess: RegisterEvent
    data class Error(val message: UiText): RegisterEvent
}