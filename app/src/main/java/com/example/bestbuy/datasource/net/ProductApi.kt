package com.example.bestbuy.datasource.net

import com.example.bestbuy.data.ProductResponseEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface ProductApi {

    @GET("products/")
    fun getProducts(@Header("Authorization") contentRange: String): Call<List<ProductResponseEntity>>
}