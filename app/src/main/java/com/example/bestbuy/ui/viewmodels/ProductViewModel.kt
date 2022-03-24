package com.example.bestbuy.ui.viewmodels

import androidx.lifecycle.*
import com.example.bestbuy.repository.ProductRepository
import com.example.core_data.utils.ExecutorViewModel
import com.example.core_domain.Product
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject

class ProductViewModel: ExecutorViewModel() {

    private val productRepository: ProductRepository by inject(ProductRepository::class.java)
    private lateinit var _products: MutableLiveData<List<Product>>

    val products: LiveData<List<Product>>
        get() {
            if (!::_products.isInitialized) {
                _products = MutableLiveData()
                viewModelScope.launch {
                    productRepository.getProducts().collect {
                        _products.value = it
                    }
                }
            }

            return _products
        }


}