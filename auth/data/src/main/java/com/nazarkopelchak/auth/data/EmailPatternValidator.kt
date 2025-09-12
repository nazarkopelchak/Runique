package com.nazarkopelchak.auth.data

import android.util.Patterns
import com.nazarkopelchak.auth.domain.PatternValidator

object EmailPatternValidator: PatternValidator {
    override fun matches(value: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(value).matches()
    }
}