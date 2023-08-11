package com.example.awesomerates.di

import com.example.awesomerates.ui.viewmodel.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::UserViewModel)
}