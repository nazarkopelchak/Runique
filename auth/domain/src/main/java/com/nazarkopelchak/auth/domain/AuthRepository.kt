package com.nazarkopelchak.auth.domain

import com.nazarkopelchak.core.domain.util.DataError
import com.nazarkopelchak.core.domain.util.EmptyResult

interface AuthRepository {
    suspend fun register(email: String, password: String): EmptyResult<DataError.Network>
    suspend fun login(email: String, password: String): EmptyResult<DataError.Network>
}