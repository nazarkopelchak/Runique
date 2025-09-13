package com.nazarkopelchak.auth.data

import com.nazarkopelchak.auth.domain.AuthRepository
import com.nazarkopelchak.core.data.networking.post
import com.nazarkopelchak.core.domain.AuthInfo
import com.nazarkopelchak.core.domain.SessionStorage
import com.nazarkopelchak.core.domain.util.DataError
import com.nazarkopelchak.core.domain.util.EmptyResult
import com.nazarkopelchak.core.domain.util.Result
import com.nazarkopelchak.core.domain.util.asEmptyDataResult
import io.ktor.client.HttpClient

class AuthRepositoryImpl(
    private val httpClient: HttpClient,
    private val sessionStorage: SessionStorage
): AuthRepository {
    override suspend fun register(
        email: String,
        password: String
    ): EmptyResult<DataError.Network> {
        return httpClient.post<RegisterRequest, Unit>(
            route = "/register",
            body = RegisterRequest(
                email = email,
                password = password
            )
        )
    }

    override suspend fun login(
        email: String,
        password: String
    ): EmptyResult<DataError.Network> {
        val result = httpClient.post<LoginRequest, LoginResponse>(
            route = "/login",
            body = LoginRequest(
                email = email,
                password = password
            )
        )

        if (result is Result.Success) {
            sessionStorage.set(
                authInfo = AuthInfo(
                    accessToken = result.data.accessToken,
                    refreshToken = result.data.refreshToken,
                    userId = result.data.userId
                )
            )
        }

        return result.asEmptyDataResult()
    }
}