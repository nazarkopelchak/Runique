package com.nazarkopelchak.auth.presentation.login

sealed interface LoginAction {
    data object OnRegisterClick: LoginAction
    data object OnLoginClick: LoginAction
    data object OnTogglePasswordVisibility: LoginAction
}