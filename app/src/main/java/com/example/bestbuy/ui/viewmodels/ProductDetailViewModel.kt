package com.example.bestbuy.ui.viewmodels

import androidx.lifecycle.*
import com.example.bestbuy.repository.ProductRepository
import com.example.core_data.utils.ExecutorViewModel
import com.example.core_domain.ProductDetail
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent
import org.koin.java.KoinJavaComponent.inject

open class ProductDetailViewModel : ExecutorViewModel() {

    var idProduct: Int = 0
    private lateinit var _product: MutableLiveData<ProductDetail>
    val thereIsStock = MutableLiveData<Boolean>()
    private val productRepository: ProductRepository by inject(ProductRepository::class.java)

    val product: LiveData<ProductDetail>
        get() {
            if (!::_product.isInitialized) {
                _product = MutableLiveData()
                viewModelScope.launch {
                    productRepository.getProductById(idProduct).collect {
                        _product.value = it
                    }
                }

            }

            return _product
        }


    fun onAddCartButtonClicked() {
        _product.value?.let {
            thereIsStock.value = it.stock?.let {
                it > 0
            } ?: false
        }
    }
}