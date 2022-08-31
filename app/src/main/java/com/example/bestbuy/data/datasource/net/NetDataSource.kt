package com.example.bestbuy.data.datasource.net

import com.example.bestbuy.data.models.ProductDetailEntity
import com.example.bestbuy.data.models.ProductEntity

interface NetDataSource {

    suspend fun getProductList(): List<ProductEntity>?

    suspend fun getProductById(idProduct: Int): ProductDetailEntity?
}