package com.example.bestbuy

import android.app.Application
import com.example.bestbuy.di.appModuleDependencies
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.module

class BestBuyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger()
            androidContext(this@BestBuyApp)
            module {
                appModuleDependencies
            }
        }
    }
}