package com.manday.marvel.ui.viewmodels

import androidx.lifecycle.*
import com.manday.marvel.data.models.CharacterEntity
import com.manday.marvel.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject

class ProductListViewModel: ViewModel() {

    private val productRepository: CharacterRepository by inject(CharacterRepository::class.java)
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
         val character: List<CharacterEntity>? = null
    )
}