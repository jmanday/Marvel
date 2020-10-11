package com.example.bestbuy.repository

import androidx.lifecycle.LiveData

interface ProductRepository {

    fun getProducts(): LiveData<List<String>?>
}