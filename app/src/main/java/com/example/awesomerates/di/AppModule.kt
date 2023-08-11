package com.example.awesomerates.di

import com.example.awesomerates.domain.User
import org.koin.dsl.module

val appModule = module {
        single { User("Trolla") }
}