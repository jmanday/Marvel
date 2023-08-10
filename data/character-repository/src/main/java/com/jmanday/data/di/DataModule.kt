package com.jmanday.data.di

import com.jmanday.data.repository.InternalCharacterRepository
import com.jmanday.domain.repository.CharacterRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindCharacterRepository(
        characterRepository: InternalCharacterRepository
    ): CharacterRepository
}