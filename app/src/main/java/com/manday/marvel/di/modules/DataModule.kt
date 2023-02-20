package com.manday.marvel.di.modules

import android.content.Context
import com.manday.marvel.data.datasource.LocalDataSource
import com.manday.marvel.data.datasource.NetDataSource
import com.manday.marvel.data.datasource.db.models.MarvelCharacter
import com.manday.marvel.data.datasource.db.room.CharacterDao
import com.manday.marvel.data.datasource.db.room.MarvelDatabase
import com.manday.marvel.data.datasource.db.room.RoomDataSource
import com.manday.marvel.data.datasource.net.retrofit.RetrofitDataSource
import com.manday.marvel.domain.repository.CharacterRepository
import com.manday.marvel.domain.repository.InternalCharacterRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
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

    @Singleton
    @Binds
    abstract fun provideLocalDataSource(impl: RoomDataSource): LocalDataSource
}

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) = MarvelDatabase.getDatabase(context)

    @Provides
    @Singleton
    fun provideDao(db: MarvelDatabase) = db.CharacterDao()

    @Provides
    fun provideEntity() = MarvelCharacter()
}

@Module
@InstallIn(ViewModelComponent::class)
internal object ViewModelCharacterModule {

    @Provides
    @ViewModelScoped
    fun provideCharacterRepository(netDataSource: NetDataSource, localDataSource: LocalDataSource): CharacterRepository
        = InternalCharacterRepository(netDataSource, localDataSource)

}
