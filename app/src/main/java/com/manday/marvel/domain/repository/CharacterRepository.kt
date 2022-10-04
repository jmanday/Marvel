package com.manday.marvel.domain.repository

import com.manday.marvel.data.models.CharacterEntity
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {

    suspend fun getCharacters(): Flow<List<CharacterEntity>?>
}