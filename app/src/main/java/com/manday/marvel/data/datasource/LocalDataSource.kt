package com.manday.marvel.data.datasource

import com.manday.marvel.data.datasource.db.models.MarvelCharacter
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    suspend fun getCharacters(): Flow<List<MarvelCharacter>>

    suspend fun saveCharacters(marvelCharacterList: List<MarvelCharacter>)
}