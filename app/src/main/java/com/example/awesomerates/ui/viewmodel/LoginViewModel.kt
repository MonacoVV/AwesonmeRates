package com.example.awesomerates.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.awesomerates.data.UserInfoStateRepository
import com.example.awesomerates.domain.UserInfo
import kotlinx.coroutines.launch

class LoginViewModel(
    val userInfoStateRepository: UserInfoStateRepository
) : ViewModel() {
    fun onLoginClicked(username: String) {
        viewModelScope.launch {
            userInfoStateRepository.setUserInfo(
                UserInfo(username)
            )
        }
    }
}