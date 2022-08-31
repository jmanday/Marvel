package com.example.bestbuy.data.datasource

import com.example.bestbuy.data.models.ProductDetailEntity
import com.example.bestbuy.data.models.ProductEntity

interface ProductDataSource {

    suspend fun getProductList(): List<ProductEntity>?

    suspend fun getProductById(idProduct: Int): ProductDetailEntity?
}