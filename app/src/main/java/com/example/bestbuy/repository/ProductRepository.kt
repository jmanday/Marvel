package com.example.bestbuy.repository

import com.example.core_domain.Product
import com.example.core_domain.ProductDetail
import kotlinx.coroutines.flow.Flow

interface ProductRepository {

    suspend fun getProducts(): Flow<List<Product>?>

    fun getProductById(idProduct: Int): Flow<ProductDetail?>
}