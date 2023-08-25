package com.example.awesomerates.data

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.awesomerates.domain.UserInfo
import com.example.awesomerates.ext.dataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class UserInfoLocalDataSource(val context: Context) {

    private val USER_INFO_KEY = stringPreferencesKey("user_info")

    suspend fun saveUserInfo(authState: UserInfo) {
        context.dataStore.edit { settings ->
            settings[USER_INFO_KEY] = Json.encodeToString(authState)
        }
    }

    fun subscribeUserInfo(): Flow<UserInfo?> {
        return context.dataStore.data.map { preferencies ->
            val rawState = preferencies[USER_INFO_KEY]
            runCatching {
                requireNotNull(rawState)
                Json.decodeFromString<UserInfo>(rawState)
            }.getOrNull()
        }
    }

    suspend fun cleanUserInfo() {
        context.dataStore.edit { settings ->
           settings.remove(USER_INFO_KEY)
        }
    }

    suspend fun getUserInfo() : UserInfo? {
        return context.dataStore.data.map { preferencies ->
            val rawState = preferencies[USER_INFO_KEY]
            runCatching {
                requireNotNull(rawState)
                Json.decodeFromString<UserInfo>(rawState)
            }.getOrNull()
        }.first()
    }
}