package com.example.bestbuy.ui.viewmodels

import com.example.bestbuy.data.datasource.RemoteProductDataSource
import com.example.bestbuy.repository.ProductRepository
import com.example.bestbuy.repository.ProductRepositoryImpl
import com.example.core_data.utils.ExecutorViewModel
import org.koin.java.KoinJavaComponent.inject

class ProductViewModel: ExecutorViewModel() {

    //private val productRepository: ProductRepository by inject(ProductRepository::class.java)
    private val productRepository: ProductRepository = ProductRepositoryImpl(RemoteProductDataSource())

    fun getProducts() =
        doInBackground {
            productRepository.getProducts()
        }


}