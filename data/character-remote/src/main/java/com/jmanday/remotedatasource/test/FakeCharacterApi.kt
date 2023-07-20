package com.jmanday.remotedatasource.test

import com.jmanday.remotedatasource.api.CharacterApi
import com.jmanday.remotedatasource.dto.CharactersResponse

class FakeCharacterApi : CharacterApi {

    override suspend fun getCharacters(
        timestamp: String,
        apiKey: String,
        limit: Int,
        hashCode: String
    ): CharactersResponse = characterResponseDto
}