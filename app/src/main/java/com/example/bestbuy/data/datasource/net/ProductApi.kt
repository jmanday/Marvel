package com.example.bestbuy.data.datasource.net

import com.example.bestbuy.data.ProductDetailEntity
import com.example.bestbuy.data.ProductResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductApi {

    @GET("products/")
    fun getProducts(): Call<ProductResponse>

    @GET("products/{id}")
    fun getProductsById(@Path("id") id: Int?): Call<ProductDetailEntity>

}