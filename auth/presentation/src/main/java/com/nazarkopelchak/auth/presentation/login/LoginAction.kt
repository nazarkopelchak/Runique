package com.nazarkopelchak.auth.presentation.login

sealed interface LoginAction {
    data object OnRegisterClick: LoginAction
}