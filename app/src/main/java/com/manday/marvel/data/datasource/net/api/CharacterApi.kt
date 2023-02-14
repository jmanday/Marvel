package com.manday.marvel.data.datasource.net.api

import com.manday.marvel.data.datasource.net.models.CharactersResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterApi {

    @GET("characters")
    suspend fun getCharacters(
        @Query("ts") timestamp: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hashCode: String): Response<CharactersResponse>

}