package com.example.bestbuy.ui.viewmodels

import androidx.lifecycle.*
import com.example.bestbuy.data.models.CharacterEntity
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
        _productListState.value = UIProductListState(loading = true)
        viewModelScope.launch {
            _productListState.value = UIProductListState(character = productRepository.getCharacters().first())
        }
    }

    data class UIProductListState(
         val loading: Boolean = false,
         val products: List<ProductModel>? = null,
         val character: CharacterEntity? = null
    )
}