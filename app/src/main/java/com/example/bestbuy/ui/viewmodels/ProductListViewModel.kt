package com.example.bestbuy.ui.viewmodels

import androidx.lifecycle.*
import com.example.bestbuy.repository.ProductRepository
import com.example.core_domain.Product
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject

class ProductListViewModel: ViewModel() {

    private val productRepository: ProductRepository by inject(ProductRepository::class.java)
    private val _state = MutableStateFlow(UIProductListState())
    val state: StateFlow<UIProductListState> = _state.asStateFlow()

    init {
        refresh()
    }

    private fun refresh() {
        viewModelScope.launch {
            _state.value = UIProductListState(loading = true)
            _state.value = UIProductListState(products = productRepository.getProducts().first())
        }
    }

    data class UIProductListState(
         val loading: Boolean = false,
         val products: List<Product>? = null,
         val navigateTo: Product? = null
    )
}

/*
@Suppress("UNCHECKED_CAST")
class ProductViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProductViewModel() as T
    }
}
 */