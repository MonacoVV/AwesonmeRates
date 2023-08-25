package com.example.awesomerates.data

import com.example.awesomerates.domain.UserInfo
import kotlinx.coroutines.flow.Flow

class UserInfoStateRepository(private val dataSource: UserInfoLocalDataSource) {
    fun subscribeUserInfo(): Flow<UserInfo?> {
        return dataSource.subscribeUserInfo()
    }
    suspend fun getUserInfo(): UserInfo? = dataSource.getUserInfo()
    suspend fun cleanUserInfo() = dataSource.cleanUserInfo()
    suspend fun setUserInfo(userInfo: UserInfo) = dataSource.saveUserInfo(userInfo)
}