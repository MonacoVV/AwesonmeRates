package com.example.awesomerates.initializers

import android.content.Context
import androidx.startup.Initializer
import com.example.awesomerates.data.UserInfoLocalDataSource
import com.example.awesomerates.manager.AccountManager
import kotlinx.coroutines.runBlocking


class AccountManagerInitializer : Initializer<AccountManager> {
    override fun create(context: Context): AccountManager {
        val isAuthorized = runBlocking {
           UserInfoLocalDataSource(context).getUserInfo()
        } != null
        AccountManager.isAuthorized = isAuthorized
        return AccountManager.newInstance()
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return emptyList()
    }
}