package com.jmanday.remotedatasource.api

import com.jmanday.remotedatasource.dto.CharactersResponse
import retrofit2.http.GET
import retrofit2.http.Query

const val MIN_LIMIT_CHARACTERS = 20

interface CharacterApi {

    @GET("characters")
    suspend fun getCharacters(
        @Query("ts") timestamp: String,
        @Query("apikey") apiKey: String,
        @Query("limit") limit: Int = MIN_LIMIT_CHARACTERS,
        @Query("hash") hashCode: String): CharactersResponse
}

internal const val BASE_URL = "http://gateway.marvel.com/v1/public/"
internal const val AUTHORIZATION = "ddf49ca9-44cf-4613-b218-ddc030bbfa63"