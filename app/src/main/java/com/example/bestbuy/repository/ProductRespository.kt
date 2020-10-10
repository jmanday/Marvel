package com.example.bestbuy.repository

import androidx.lifecycle.LiveData

interface ProductRespository {

    fun getProducts(): LiveData<List<String>?>
}