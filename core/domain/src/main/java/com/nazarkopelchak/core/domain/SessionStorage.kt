package com.nazarkopelchak.core.domain

interface SessionStorage {

    suspend fun get(): AuthInfo?
    suspend fun set(authInfo: AuthInfo?)
}