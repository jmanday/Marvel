package com.manday.marvel.data.datasource.db.models

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class MarvelCharacter(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "description") val email: String?,
    @ColumnInfo(name = "thumbnailPath") val avatar: String?
)
