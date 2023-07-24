package com.jmanday.data.di

import com.jmanday.data.repository.InternalCharacterRespository
import com.jmanday.domain.repository.CharacterRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindCharacterRespository(
        characterRepository: InternalCharacterRespository
    ): CharacterRepository
}