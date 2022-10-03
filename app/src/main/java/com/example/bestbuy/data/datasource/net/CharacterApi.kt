package com.example.bestbuy.data.datasource.net

import com.example.bestbuy.data.models.CharactersResponse
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