package com.jmanday.domain.repository

import com.jmanday.domain.model.Character
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    suspend fun getCharacters(): Flow<List<Character>>
}