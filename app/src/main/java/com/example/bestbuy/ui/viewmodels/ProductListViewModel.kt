package com.example.bestbuy.ui.viewmodels

import androidx.lifecycle.*
import com.example.bestbuy.domain.repository.ProductRepository
import com.example.bestbuy.mapper.toListProductModel
import com.example.bestbuy.ui.models.ProductModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject

class ProductListViewModel: ViewModel() {

    private val productRepository: ProductRepository by inject(ProductRepository::class.java)
    private val _productListState = MutableStateFlow(UIProductListState())
    val productListState: StateFlow<UIProductListState> = _productListState.asStateFlow()

    init {
        refresh()
    }

    private fun refresh() {
        viewModelScope.launch {
            _productListState.value = UIProductListState(loading = true)
            _productListState.value = UIProductListState(products = productRepository.getProducts().first()?.toListProductModel())
        }
    }

    data class UIProductListState(
         val loading: Boolean = false,
         val products: List<ProductModel>? = null
    )
}