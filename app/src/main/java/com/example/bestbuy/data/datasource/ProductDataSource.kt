package com.example.bestbuy.data.datasource

import androidx.lifecycle.LiveData

interface ProductDataSource {

    fun getProductList(): LiveData<List<String>?>
}