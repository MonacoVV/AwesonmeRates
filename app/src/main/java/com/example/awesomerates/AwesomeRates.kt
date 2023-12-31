package com.example.awesomerates

import android.app.Application
import com.example.awesomerates.di.appModule
import com.example.awesomerates.di.dataStoreModule
import com.example.awesomerates.di.managerModule
import com.example.awesomerates.di.repositoryModule
import com.example.awesomerates.di.useCaseModule
import com.example.awesomerates.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AwesomeRates: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AwesomeRates)
            modules(
                appModule,
                viewModelModule,
                repositoryModule,
                dataStoreModule,
                useCaseModule,
                managerModule,
            )
        }
    }
}