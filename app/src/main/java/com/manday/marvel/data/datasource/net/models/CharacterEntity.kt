package com.manday.marvel.data.datasource.net.models

import android.os.Parcelable
import com.manday.marvel.data.datasource.db.models.MarvelCharacter
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CharacterEntity(
    val name: String,
    val description: String,
    val thumbnailPath: String
): Parcelable

fun CharacterEntity.toMarveCharacter() =
    MarvelCharacter(
        name = this.name,
        description = this.description,
        avatar = this.thumbnailPath
    )

fun List<CharacterEntity>.toListMarvelCharacter() = this.map {
    MarvelCharacter(
        name = it.name,
        description = it.description,
        avatar = it.thumbnailPath
    )
}