package com.example.bestbuy.di

import android.app.Application
import androidx.room.Room
import com.example.bestbuy.data.datasource.db.*
import com.example.bestbuy.data.datasource.net.NetDataSource
import com.example.bestbuy.data.datasource.net.RetrofitDataSource
import com.example.bestbuy.navigation.NavigateFromProductToDetailFragment
import com.example.bestbuy.domain.repository.InternalCharacterRepository
import com.example.bestbuy.domain.repository.CharacterRepository
import com.example.core_ui.transitions.ContainerTransformFade
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val appModuleDependencies = module {

    fun provideDataBase(application: Application): ProductDatabase {
        return Room.databaseBuilder(
            application,
            ProductDatabase::class.java, "product-database"
        ).build()
    }

    fun provideDao(dataBase: ProductDatabase): ProductDao {
        return dataBase.productDao()
    }

    // Single instances
    single<NetDataSource> { RetrofitDataSource() }
    single<LocalDataSource> { RoomDataSource(provideDao(provideDataBase(androidApplication()))) }

    single<CharacterRepository> {
        InternalCharacterRepository(
            get(),
            get())
    }

    factory { ContainerTransformFade() }
    factory { NavigateFromProductToDetailFragment() }
}