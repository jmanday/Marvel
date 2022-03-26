package com.example.bestbuy

import android.app.Application
import androidx.room.Room
import com.example.bestbuy.data.datasource.db.ProductDatabase
import com.example.bestbuy.di.appModuleDependencies
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BestBuyApp : Application() {

    lateinit var db: ProductDatabase
        private set

    override fun onCreate() {
        super.onCreate()

        db = Room.databaseBuilder(
            this,
            ProductDatabase::class.java, "product-database"
        ).build()

        startKoin{
            androidLogger()
            androidContext(this@BestBuyApp)
            modules(appModuleDependencies)
        }
    }
}