package com.example.awesomerates.ui.viewmodel

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.awesomerates.data.UserInfoStateRepository
import com.example.awesomerates.domain.UserInfo
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch

@Stable
class RatesViewModel(val repository: UserInfoStateRepository) : ViewModel() {

    var userName: String by mutableStateOf("")
        private set

    init {
        viewModelScope.launch {
            repository.subscribeUserInfo().filterNotNull().collect {
                userName = it.name
            }
        }
    }

    fun onSaveClicked() {
        viewModelScope.launch {
            repository.setUserInfo(UserInfo(userName))
        }
    }

    fun onAuthChanged(state: String) {
        userName = state
    }
}