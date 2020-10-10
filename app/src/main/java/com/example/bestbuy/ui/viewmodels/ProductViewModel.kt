package com.example.bestbuy.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bestbuy.data.ProductEntity

class ProductViewModel: ViewModel() {

    var products = MutableLiveData<List<ProductEntity>>()

    init {

    }
}