package com.example.bestbuy.repository

import androidx.lifecycle.LiveData
import com.example.core_domain.Product
import com.example.core_domain.ProductDetail

interface ProductRepository {

    fun getProducts(): LiveData<List<Product>?>?

    fun getProductById(idProduct: Int): LiveData<ProductDetail?>?
}