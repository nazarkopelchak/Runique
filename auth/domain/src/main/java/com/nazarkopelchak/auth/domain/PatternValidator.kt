package com.nazarkopelchak.auth.domain

interface PatternValidator {
    fun matches(value: String): Boolean
}