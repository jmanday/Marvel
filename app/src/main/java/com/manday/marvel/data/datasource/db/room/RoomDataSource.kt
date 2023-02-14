package com.manday.marvel.data.datasource.db.room

import com.manday.marvel.data.datasource.LocalDataSource
import com.manday.marvel.data.datasource.db.models.MarvelCharacter

class RoomDataSource(
    private val characterDao: CharacterDao
) : LocalDataSource {

    override suspend fun getCharacters(): List<MarvelCharacter> {
        TODO("Not yet implemented")
    }
}