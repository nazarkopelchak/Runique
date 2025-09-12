package com.nazarkopelchak.auth.domain

class UserDataValidator(
    private val emailPatternValidator: PatternValidator,
) {
    fun isValidEmail(email: String): Boolean {
        return emailPatternValidator.matches(email.trim())
    }

    fun validatePassword(password: String): PasswordValidationState {
        return PasswordValidationState(
            hasMinLength = password.length >= MIN_PASSWORD_LENGTH,
            hasNumber = password.any { it.isDigit() },
            hasUpperCase = password.any { it.isUpperCase() },
            hasLowerCase = password.any { it.isLowerCase() }
        )
    }

    companion object {
        const val MIN_PASSWORD_LENGTH = 9
    }
}