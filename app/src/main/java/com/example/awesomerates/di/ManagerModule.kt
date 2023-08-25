package com.example.awesomerates.di

import com.example.awesomerates.manager.AccountManager
import org.koin.dsl.module

val managerModule = module {
    single { AccountManager.newInstance() }
}