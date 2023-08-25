package com.example.awesomerates.di

import com.example.awesomerates.domain.GetAuthorizedStateUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { GetAuthorizedStateUseCase(get()) }
}