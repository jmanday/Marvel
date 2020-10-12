package com.example.bestbuy.ui.viewmodels

import com.example.bestbuy.repository.ProductRepository
import com.example.core_data.utils.ExecutorViewModel
import org.koin.java.KoinJavaComponent

class ProductDetailViewModel : ExecutorViewModel() {

    private val productRepository: ProductRepository by KoinJavaComponent.inject(ProductRepository::class.java)

    fun getProductById(idProduct: Int) =
        doInBackground {
            productRepository.getProductById(idProduct)
        }
}