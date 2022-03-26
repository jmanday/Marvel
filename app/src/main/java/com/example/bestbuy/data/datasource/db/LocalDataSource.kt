package com.example.bestbuy.data.datasource.db

interface LocalDataSource {

    suspend fun saveProducts(products: List<Product>)

    suspend fun getProducts(): List<Product>
}