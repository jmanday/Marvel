package com.manday.marvel.data.datasource.db.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.manday.marvel.data.datasource.db.models.MarvelCharacter
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterDao {

    @Query("SELECT * FROM marvel_character_table")
    fun getAll(): Flow<List<MarvelCharacter>>

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(characters: List<MarvelCharacter>)

    @Insert
    suspend fun insertCharacter(character: MarvelCharacter)

    @Delete
    suspend fun delete(character: MarvelCharacter)
}