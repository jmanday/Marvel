package com.example.bestbuy.ui.viewmodels

import androidx.lifecycle.*
import com.example.bestbuy.repository.ProductRepository
import com.example.core_domain.ProductDetail
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject

open class ProductDetailViewModel : ViewModel() {

    private val productRepository: ProductRepository by inject(ProductRepository::class.java)
    var idProduct: Int = 0
        set(value) {
            field = value
            refreshUI()
        }
    private var _product = MutableStateFlow(UIDetailState())
    val product: StateFlow<UIDetailState> = _product.asStateFlow()

    private fun refreshUI() {
        viewModelScope.launch {
            val product = productRepository.getProductById(idProduct).first()
            _product.value = UIDetailState(
                isFound = true,
                product = product,
                available = product?.stock?.let { it > 0 } ?: false,
                discount = product?.discountPrice?.let { true }  ?: false
            )
        }
    }

    fun onAddCartButtonClicked() {

    }

    data class UIDetailState(
        val isFound: Boolean = false,
        val product: ProductDetail? = null,
        val available: Boolean = false,
        val discount: Boolean = false
    )
}