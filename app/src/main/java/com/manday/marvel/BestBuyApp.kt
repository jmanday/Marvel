package com.manday.marvel

import android.app.Application
import androidx.room.Room
import com.manday.marvel.data.datasource.db.ProductDatabase
import com.manday.marvel.di.appModuleDependencies
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