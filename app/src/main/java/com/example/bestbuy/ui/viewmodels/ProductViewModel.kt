package com.example.bestbuy.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bestbuy.data.ProductEntity
import com.example.bestbuy.data.datasource.RemoteProductDataSource
import com.example.bestbuy.repository.ProductRepository
import com.example.bestbuy.repository.ProductRepositoryImpl
import org.koin.java.KoinJavaComponent.inject

class ProductViewModel: ViewModel() {

    //private val productRepository: ProductRepository by inject(ProductRepository::class.java)
    private val productRepository: ProductRepository = ProductRepositoryImpl(RemoteProductDataSource())

    fun getProducts() =
        productRepository.getProducts()

}