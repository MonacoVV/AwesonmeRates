package com.example.awesomerates.ui.viewmodel

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.awesomerates.data.UserInfoStateRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

@Stable
class UserViewModel(
    private val userInfoStateRepository: UserInfoStateRepository,
) : ViewModel() {

    val userFlow: StateFlow<String> = userInfoStateRepository.subscribeUserInfo()
        .map { it?.name ?: "" }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = ""
        )

    var loading: Boolean by mutableStateOf(false)
        private set

    fun onLogoutClicked() {
        viewModelScope.launch {
            kotlin.runCatching {
                loading = true
                userInfoStateRepository.cleanUserInfo()
            }
            loading = false
        }
    }
}