package com.example.bestbuy.data.datasource.net

import com.example.bestbuy.data.ProductDetailEntity
import com.example.bestbuy.data.ProductResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductApi {

    @GET("products/")
    suspend fun getProducts(): Response<ProductResponse>

    @GET("products/{id}")
    suspend fun getProductsById(@Path("id") id: Int?): Response<ProductDetailEntity>

}