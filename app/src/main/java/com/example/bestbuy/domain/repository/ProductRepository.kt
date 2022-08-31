package com.example.bestbuy.domain.repository

import com.example.bestbuy.domain.models.Product
import com.example.bestbuy.domain.models.ProductDetail
import kotlinx.coroutines.flow.Flow

interface ProductRepository {

    suspend fun getProducts(): Flow<List<Product>?>

    fun getProductById(idProduct: Int): Flow<ProductDetail?>
}