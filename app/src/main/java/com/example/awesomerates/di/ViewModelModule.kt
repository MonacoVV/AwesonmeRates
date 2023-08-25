package com.example.awesomerates.di

import com.example.awesomerates.ui.viewmodel.UserViewModel
import com.example.awesomerates.ui.viewmodel.MainViewModel
import com.example.awesomerates.ui.viewmodel.RatesViewModel
import com.example.awesomerates.ui.viewmodel.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::UserViewModel)
    viewModelOf(::MainViewModel)
    viewModelOf(::RatesViewModel)
    viewModelOf(::LoginViewModel)
}