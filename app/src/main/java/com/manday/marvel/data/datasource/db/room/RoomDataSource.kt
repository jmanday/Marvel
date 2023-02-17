package com.manday.marvel.data.datasource.db.room

import com.manday.marvel.data.datasource.LocalDataSource
import com.manday.marvel.data.datasource.db.models.MarvelCharacter
import javax.inject.Inject

class RoomDataSource @Inject constructor(
    private val characterDao: CharacterDao
) : LocalDataSource {

    override suspend fun getCharacters(): List<MarvelCharacter> {
        return characterDao.getAll()
    }

    override suspend fun saveCharacters(marvelCharacterList: List<MarvelCharacter>) {
        characterDao.insertAll(marvelCharacterList)
    }
}