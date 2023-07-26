package com.jmanday.domain.test

import com.jmanday.domain.model.Character
import com.jmanday.domain.model.Thumbnail

val thumbnail = Thumbnail(
    path = "/path/to/some/place",
    extension = ".png"
)

val character = Character(
    id = "id",
    name = "name",
    description = "some description",
    thumbnail = thumbnail
)

val characterList = listOf(character)