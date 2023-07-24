package com.jmanday.data.mapper

import com.jmanday.domain.model.Character
import com.jmanday.domain.model.Thumbnail
import com.jmanday.remotedatasource.dto.CharacterThumbnail
import com.jmanday.remotedatasource.dto.CharactersResponse
import com.jmanday.remotedatasource.dto.CharactersResults

fun CharactersResponse.toCharacterList(): List<Character> {
    return data.results
        .map { it.toCharacter() }
}

fun CharactersResults.toCharacter() = Character(
    id = id,
    name = name,
    description = description,
    thumbnail = thumbnail.toThumbnail()
)

fun CharacterThumbnail.toThumbnail() = Thumbnail(
    path = path,
    extension = extension
)