package com.example.bestbuy.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import com.example.bestbuy.repository.ProductRepository
import com.example.core_data.utils.ExecutorViewModel
import com.example.core_domain.ProductDetail
import org.koin.java.KoinJavaComponent

open class ProductDetailViewModel : ExecutorViewModel() {

    var selectedProduct: ProductDetail? = null
    val thereIsStock = MutableLiveData<Boolean>()
    private val productRepository: ProductRepository by KoinJavaComponent.inject(ProductRepository::class.java)

    fun getProductById(idProduct: Int) =
        doInBackground {
            productRepository.getProductById(idProduct)
        }

    fun onAddCartButtonClicked() {
        selectedProduct?.let {
            thereIsStock.value = it.stock?.let {
                it > 0
            } ?: false
        }
    }
}