package com.example.awesomerates.di

import com.example.awesomerates.data.UserInfoStateRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val repositoryModule = module {
    singleOf(::UserInfoStateRepository)
}