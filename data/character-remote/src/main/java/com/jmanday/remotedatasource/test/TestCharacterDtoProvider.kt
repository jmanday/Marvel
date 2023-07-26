package com.jmanday.remotedatasource.test

import com.jmanday.remotedatasource.dto.CharacterThumbnail
import com.jmanday.remotedatasource.dto.CharactersData
import com.jmanday.remotedatasource.dto.CharactersResponse
import com.jmanday.remotedatasource.dto.CharactersResults

val characterThumbnailDto = CharacterThumbnail(
    path = "/path/to/some/place",
    extension = ".png"
)

val characterResultDto = CharactersResults(
    id = "id",
    name = "name",
    description = "some description",
    modified = "modified",
    thumbnail = characterThumbnailDto
)

val characterDataDto = CharactersData(
    offset = 1,
    limit = 1,
    total = 1,
    count = 1,
    results = listOf(characterResultDto)
)


val characterResponseDto = CharactersResponse(
    code = 1,
    status = "status",
    copyright = "copyright",
    etag = "etag",
    data = characterDataDto
)