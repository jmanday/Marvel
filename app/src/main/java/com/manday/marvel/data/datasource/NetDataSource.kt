package com.manday.marvel.data.datasource

import com.manday.marvel.data.datasource.net.models.CharacterEntity

interface NetDataSource {
    suspend fun getCharacters(hashCode: String): List<CharacterEntity>
}