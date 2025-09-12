package com.nazarkopelchak.auth.domain

data class PasswordValidationState(
    val hasMinLength: Boolean = false,
    val hasNumber: Boolean = false,
    val hasUpperCase: Boolean = false,
    val hasLowerCase: Boolean = false,
){
    val isValidPassword: Boolean
        get() = hasMinLength && hasNumber && hasUpperCase && hasLowerCase
}
