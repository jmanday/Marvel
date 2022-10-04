package com.example.bestbuy.domain.repository

import com.example.bestbuy.data.models.CharacterEntity
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {

    suspend fun getCharacters(): Flow<List<CharacterEntity>?>
}