package com.example.bestbuy.ui.viewmodels

import com.example.bestbuy.repository.ProductRepository
import com.example.core_data.utils.ExecutorViewModel
import org.koin.java.KoinJavaComponent.inject

class ProductViewModel: ExecutorViewModel() {

    private val productRepository: ProductRepository by inject(ProductRepository::class.java)

    fun getProducts() =
        doInBackground {
            productRepository.getProducts()
        }


}