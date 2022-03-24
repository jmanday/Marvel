package com.example.bestbuy.data.datasource

import com.example.bestbuy.data.ProductDetailEntity
import com.example.bestbuy.data.ProductEntity

interface ProductDataSource {

    suspend fun getProductList(): List<ProductEntity>?

    suspend fun getProductById(idProduct: Int): ProductDetailEntity?
}