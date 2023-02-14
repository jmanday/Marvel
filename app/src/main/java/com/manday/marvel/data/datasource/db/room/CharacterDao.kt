package com.manday.marvel.data.datasource.db.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.manday.marvel.data.datasource.db.models.MarvelCharacter

@Dao
interface CharacterDao {

    @Query("SELECT * FROM marvel_character_table")
    fun getAll(): List<MarvelCharacter>

    @Insert
    fun insertAll(characters: List<MarvelCharacter>)

    @Delete
    fun delete(character: MarvelCharacter)
}