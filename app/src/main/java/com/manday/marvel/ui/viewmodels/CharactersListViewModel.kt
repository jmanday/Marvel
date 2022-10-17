package com.manday.marvel.ui.viewmodels

import androidx.lifecycle.*
import com.manday.marvel.data.datasource.db.RoomDataSource
import com.manday.marvel.data.datasource.net.RetrofitDataSource
import com.manday.marvel.data.models.CharacterEntity
import com.manday.marvel.domain.repository.CharacterRepository
import com.manday.marvel.domain.repository.CharacterResult
import com.manday.marvel.domain.repository.InternalCharacterRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import org.koin.android.ext.koin.androidApplication
import org.koin.java.KoinJavaComponent.inject

class CharactersListViewModel: ViewModel() {

    private val characterRepository: CharacterRepository by inject(CharacterRepository::class.java)
    private val _productListState = MutableStateFlow(UIProductListState())
    val productListState: StateFlow<UIProductListState> = _productListState.asStateFlow()

    init {
        refresh()
    }

    private fun refresh() {
        _productListState.value = UIProductListState(loading = true)

        viewModelScope.launch {
            _productListState.value = UIProductListState(characterResult =  characterRepository.getCharacters().first())
        }
    }

    data class UIProductListState(
         val loading: Boolean = false,
         val characterResult: CharacterResult? = null
    )
}