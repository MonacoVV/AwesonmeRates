package com.example.awesomerates.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.awesomerates.data.UserInfoStateRepository
import com.example.awesomerates.domain.state.MainScreenState
import com.example.awesomerates.domain.state.MainScreenStateBuilder
import com.example.awesomerates.manager.AccountManager

@Stable
class MainViewModel(
    private val repository: UserInfoStateRepository,
    private val accountManager: AccountManager
) : ViewModel() {
    var state: MainScreenState by mutableStateOf(MainScreenState())
        private set
    init {
        Log.i("MainViewModel", "Created,")
    }

    fun updateState(block: MainScreenStateBuilder.() -> Unit) {
        val builder =  MainScreenStateBuilder(base = state)
        builder.block()
        state = builder.buildState()
    }

    fun isUserAuthorized(): Boolean = accountManager.isAuthorized

}