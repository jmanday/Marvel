package com.example.bestbuy.data.datasource

import androidx.lifecycle.LiveData
import com.example.bestbuy.data.ProductDetailEntity
import com.example.bestbuy.data.ProductEntity

interface ProductDataSource {

    fun getProductList(): LiveData<List<ProductEntity>?>

    fun getProductById(idProduct: Int): LiveData<ProductDetailEntity?>
}