package com.nazarkopelchak.core.data.auth

import android.content.SharedPreferences
import com.nazarkopelchak.core.domain.AuthInfo
import com.nazarkopelchak.core.domain.SessionStorage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import androidx.core.content.edit
import kotlinx.serialization.json.Json

class EncryptedSessionStorage(
    private val sharedPreferences: SharedPreferences
): SessionStorage {
    override suspend fun get(): AuthInfo? {
        return withContext(Dispatchers.IO) {
            val json = sharedPreferences.getString(AUTH_INFO_KEY, null)
            json?.let {
                Json.decodeFromString<AuthInfoSerializable>(it).toAuthInfo()
            }
        }
    }

    override suspend fun set(authInfo: AuthInfo?) {
        withContext(Dispatchers.IO) {
            if (authInfo == null) {
                sharedPreferences.edit(commit = true) { remove(AUTH_INFO_KEY) }
                return@withContext
            }
            val json = Json.encodeToString(authInfo.toAuthInfoSerializable())
            sharedPreferences.edit(commit = true) {
                putString(AUTH_INFO_KEY, json)
            }
        }
    }

    companion object {
        private const val AUTH_INFO_KEY = "AUTH_INFO_KEY"

    }
}