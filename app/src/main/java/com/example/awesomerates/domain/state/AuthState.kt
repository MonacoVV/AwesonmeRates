package com.example.awesomerates.domain.state

sealed interface AuthState {
    object Authorized: AuthState
    object UnAuthorized: AuthState
}