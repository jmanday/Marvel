package com.manday.marvel.data.datasource.net

import com.manday.marvel.data.models.CharacterEntity
import com.manday.marvel.data.models.CharactersData

interface NetDataSource {

    suspend fun getCharacters(hashCode: String): List<CharacterEntity>?
}