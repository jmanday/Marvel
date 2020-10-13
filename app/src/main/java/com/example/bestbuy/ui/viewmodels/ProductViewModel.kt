package com.example.bestbuy.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.bestbuy.repository.ProductRepository
import com.example.core_data.utils.ExecutorViewModel
import com.example.core_domain.Product
import org.koin.java.KoinJavaComponent.inject

class ProductViewModel: ExecutorViewModel() {

    private val productRepository: ProductRepository by inject(ProductRepository::class.java)
    private lateinit var _products: MediatorLiveData<List<Product>>

    val products: LiveData<List<Product>>
        get() {
            if (!::_products.isInitialized) {
                _products = MediatorLiveData()
                _products.addSource(doInBackground {
                    productRepository.getProducts()
                }) {
                    _products.value = it
                }
            }

            return _products
        }


}