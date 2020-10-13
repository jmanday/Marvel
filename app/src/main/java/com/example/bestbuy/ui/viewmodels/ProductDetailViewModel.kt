package com.example.bestbuy.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.bestbuy.repository.ProductRepository
import com.example.core_data.utils.ExecutorViewModel
import com.example.core_domain.ProductDetail
import org.koin.java.KoinJavaComponent
import org.koin.java.KoinJavaComponent.inject

open class ProductDetailViewModel : ExecutorViewModel() {

    var idProduct: Int = 0
    private lateinit var _product: MediatorLiveData<ProductDetail>
    val thereIsStock = MutableLiveData<Boolean>()
    private val productRepository: ProductRepository by inject(ProductRepository::class.java)


    val product: LiveData<ProductDetail>
        get() {
            if (!::_product.isInitialized) {
                _product = MediatorLiveData()
                _product.addSource(doInBackground {
                    productRepository.getProductById(idProduct)
                }) {
                    _product.value = it
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