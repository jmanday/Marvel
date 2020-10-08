package com.example.bestbuy.datasource

import androidx.lifecycle.LiveData

interface ProductDataSource {

    fun getProductList(): LiveData<List<String>?>
}