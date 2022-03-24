package com.example.core_data

import com.example.core_data.utils.client
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitController {

    val connections = mutableMapOf<String, Retrofit>()

    fun createConnection(baseUrl: String) {
        connections[baseUrl] = Retrofit.Builder()
            .client(client)
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    inline fun <reified T : Any> createRequest(baseUrl: String): T =
        connections.getValue(baseUrl).create(T::class.java)

    inline fun <T, U> Response<T>.unwrapResponse(f: T.() -> List<U>) =
        body()?.f()
}