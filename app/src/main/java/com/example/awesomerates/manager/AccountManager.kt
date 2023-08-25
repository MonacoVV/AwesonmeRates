package com.example.awesomerates.manager

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

@Stable
class AccountManager private constructor(
    isAuthorized: Boolean
) {

    var isAuthorized: Boolean by mutableStateOf(isAuthorized)
        private set

    companion object {
        var isAuthorized: Boolean = false
        fun newInstance(): AccountManager {
            return AccountManager(isAuthorized)
        }
    }
}
