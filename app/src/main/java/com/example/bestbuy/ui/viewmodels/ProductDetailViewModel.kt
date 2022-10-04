package com.example.bestbuy.ui.viewmodels

import androidx.lifecycle.*
import com.example.bestbuy.domain.repository.CharacterRepository
import com.example.bestbuy.ui.models.ProductDetailModel
import kotlinx.coroutines.flow.*
import org.koin.java.KoinJavaComponent.inject

open class ProductDetailViewModel : ViewModel() {

    private val productRepository: CharacterRepository by inject(CharacterRepository::class.java)
    var idProduct: Int = 0
        set(value) {
            field = value
            refreshUI()
        }
    private var _productState = MutableStateFlow(UIDetailState())
    val productState: StateFlow<UIDetailState> = _productState.asStateFlow()

    private fun refreshUI() {
        /*
        viewModelScope.launch {
            val product = productRepository.getProductById(idProduct).first()
            _productState.value = UIDetailState(
                product = product?.toProductDetailModel()
            )
        }

         */
    }

    fun onAddCartButtonClicked() {

    }

    data class UIDetailState(
        val product: ProductDetailModel? = null
    )
}