package com.example.bestbuy.repository

import androidx.lifecycle.LiveData
import com.example.bestbuy.data.datasource.ProductDataSource

class ProductRepositoryImpl(
    private val netProductDataSource: ProductDataSource
) : ProductRespository {

    override fun getProducts(): LiveData<List<String>?> {
        return netProductDataSource.getProductList()
    }
}