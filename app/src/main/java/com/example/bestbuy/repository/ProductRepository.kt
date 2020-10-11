package com.example.bestbuy.repository

import androidx.lifecycle.LiveData
import com.example.core_domain.Product

interface ProductRepository {

    fun getProducts(): LiveData<List<Product>?>?
}