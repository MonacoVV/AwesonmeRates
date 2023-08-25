package com.example.awesomerates.domain

import com.example.awesomerates.data.UserInfoStateRepository
import com.example.awesomerates.domain.state.AuthState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetAuthorizedStateUseCase(userInfoStateRepository: UserInfoStateRepository) {

    val authState: Flow<AuthState> = userInfoStateRepository.subscribeUserInfo()
        .map { if (it == null) AuthState.UnAuthorized else AuthState.Authorized }
}