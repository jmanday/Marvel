package com.example.bestbuy.data.datasource.net

import com.example.bestbuy.data.ProductResponse
import retrofit2.Call
import retrofit2.http.GET

interface ProductApi {

    @GET("products/")
    fun getProducts(): Call<ProductResponse>
}