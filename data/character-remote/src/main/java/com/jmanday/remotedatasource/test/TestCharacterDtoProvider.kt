package com.jmanday.remotedatasource.test

import com.jmanday.remotedatasource.dto.CharactersData
import com.jmanday.remotedatasource.dto.CharactersResponse

val characterDataDto = CharactersData(
    offset = 1,
    limit = 1,
    total = 1,
    count = 1,
    results = emptyList()
)


val characterResponseDto = CharactersResponse(
    code = 1,
    status = "status",
    copyright = "copyright",
    etag = "etag",
    data = characterDataDto
)