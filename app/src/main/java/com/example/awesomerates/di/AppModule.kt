package com.example.awesomerates.di

import com.example.awesomerates.domain.UserInfo
import org.koin.dsl.module

val appModule = module {
        single { UserInfo("Trolla") }
}