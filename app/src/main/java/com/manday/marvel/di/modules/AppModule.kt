package com.manday.marvel.di.modules

import com.manday.marvel.data.datasource.net.NetDataSource
import com.manday.marvel.data.datasource.net.RetrofitDataSource
import com.manday.marvel.domain.repository.CharacterRepository
import com.manday.marvel.domain.repository.InternalCharacterRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// @Module annotation which will make this class a module
// to inject dependency to other class within it's scope.
// @InstallIn(SingletonComponent::class) this will make
// this class to inject dependencies across the entire application.
@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Singleton
    @Binds
    abstract fun provideNetDataSource(impl: RetrofitDataSource): NetDataSource

}


@Module
@InstallIn(ViewModelComponent::class)
internal object ViewModelCharacterModule {

    @Provides
    @ViewModelScoped
    fun provideCharacterRepository(netNetDataSource: NetDataSource): CharacterRepository = InternalCharacterRepository(netNetDataSource)

}
