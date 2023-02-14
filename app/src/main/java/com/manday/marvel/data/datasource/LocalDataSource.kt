package com.manday.marvel.data.datasource

import com.manday.marvel.data.datasource.db.models.MarvelCharacter

interface LocalDataSource {

    suspend fun getCharacters(): List<MarvelCharacter>
}