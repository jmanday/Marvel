package com.manday.marvel.ui.viewmodels

import androidx.lifecycle.*
import com.manday.marvel.data.models.CharacterEntity
import com.manday.marvel.domain.repository.CharacterRepository
import com.manday.marvel.ui.fragments.CharacterDetailFragment
import com.manday.marvel.ui.fragments.CharacterDetailFragmentArgs
import com.manday.marvel.ui.models.ProductDetailModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import org.koin.java.KoinJavaComponent.inject
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    var character = CharacterDetailFragmentArgs.fromSavedStateHandle(savedStateHandle).character

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