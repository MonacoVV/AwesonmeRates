package com.example.awesomerates.di

import com.example.awesomerates.data.UserInfoLocalDataSource
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val dataStoreModule = module {
    singleOf(::UserInfoLocalDataSource)
}