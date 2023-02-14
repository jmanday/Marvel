package com.manday.marvel.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.manday.marvel.data.datasource.db.*
import com.manday.marvel.data.datasource.NetDataSource
import com.manday.marvel.data.datasource.net.retrofit.RetrofitDataSource
import com.manday.marvel.navigation.NavigateFromProductToDetailFragment
import com.manday.marvel.domain.repository.InternalCharacterRepository
import com.manday.marvel.domain.repository.CharacterRepository
import com.manday.core_ui.transitions.ContainerTransformFade
import com.manday.marvel.data.datasource.LocalDataSource
import com.manday.marvel.data.datasource.db.room.RoomDataSource
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
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
            get())
    }

    factory { ContainerTransformFade() }
    factory { NavigateFromProductToDetailFragment() }
}

val testModule = module {
    fun provideDataBase(application: Context): ProductDatabase {
        return Room.databaseBuilder(
            application,
            ProductDatabase::class.java, "product-database"
        ).build()
    }

    fun provideDao(dataBase: ProductDatabase): ProductDao {
        return dataBase.productDao()
    }

    single<NetDataSource> { RetrofitDataSource() }
    single<LocalDataSource> { RoomDataSource(provideDao(provideDataBase(androidContext()))) }

    single<CharacterRepository> {
        InternalCharacterRepository(
            get())
    }
}