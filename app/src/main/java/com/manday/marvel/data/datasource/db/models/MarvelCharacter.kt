package com.manday.marvel.data.datasource.db.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.manday.marvel.data.datasource.net.models.CharacterEntity

@Entity(tableName = "marvel_character_table")
data class MarvelCharacter(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "name") val name: String? = null,
    @ColumnInfo(name = "description") val description: String? = null,
    @ColumnInfo(name = "thumbnailPath") val avatar: String? = null
)

fun List<MarvelCharacter>.toListCharacterEntity() = this.map {
    CharacterEntity(
        name = it.name ?: "",
        description = it.description ?: "",
        thumbnailPath = it.avatar ?: ""
    )
}