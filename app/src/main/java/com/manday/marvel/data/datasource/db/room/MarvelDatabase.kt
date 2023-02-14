package com.manday.marvel.data.datasource.db.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.manday.marvel.data.datasource.db.models.MarvelCharacter

@Database(entities = [MarvelCharacter::class], version = 1)
abstract class MarvelDatabase : RoomDatabase() {

    abstract fun CharacterDao(): CharacterDao

    companion object {
        @Volatile
        private var INSTANCE: MarvelDatabase? = null

        fun getDatabase(context: Context): MarvelDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    MarvelDatabase::class.java,
                    "app_database")
                    .build()
                INSTANCE = instance

                instance
            }
        }

    }
}