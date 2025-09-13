package com.nazarkopelchak.auth.presentation.login

import com.nazarkopelchak.core.presentation.ui.UiText

sealed interface LoginEvents {
    data class Error(val msg: UiText): LoginEvents
    data object LoginSuccess: LoginEvents
}