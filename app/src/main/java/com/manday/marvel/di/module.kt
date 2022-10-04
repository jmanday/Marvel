package com.manday.marvel.di

import android.app.Application
import androidx.room.Room
import com.manday.marvel.data.datasource.db.*
import com.manday.marvel.data.datasource.net.NetDataSource
import com.manday.marvel.data.datasource.net.RetrofitDataSource
import com.manday.marvel.navigation.NavigateFromProductToDetailFragment
import com.manday.marvel.domain.repository.InternalCharacterRepository
import com.manday.marvel.domain.repository.CharacterRepository
import com.manday.core_ui.transitions.ContainerTransformFade
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