package com.manday.marvel.ui.viewmodels

import androidx.lifecycle.*
import com.manday.marvel.data.datasource.db.LocalDataSource
import com.manday.marvel.data.datasource.db.RoomDataSource
import com.manday.marvel.data.datasource.net.RetrofitDataSource
import com.manday.marvel.data.models.CharacterEntity
import com.manday.marvel.domain.repository.CharacterRepository
import com.manday.marvel.domain.repository.CharacterResult
import com.manday.marvel.domain.repository.InternalCharacterRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject

class CharactersListViewModel: ViewModel() {

    private val characterRepository: CharacterRepository = InternalCharacterRepository(
        RetrofitDataSource())
    private val _state = MutableStateFlow(UIProductListState())
    val state: StateFlow<UIProductListState> get() {
        if (_state.value.navigateTo != null) {
            _state.value = _state.value.copy(navigateTo = null)
        }

        return _state
    }

    init {
        refresh()
    }

    private fun refresh() {
        _state.value = UIProductListState(loading = true)

        viewModelScope.launch {
            _state.value = UIProductListState(characterResult =  characterRepository.getCharacters().first())
        }
    }

    fun onCharacterClicked(characterEntity: CharacterEntity) {
        _state.value = _state.value.copy(navigateTo = characterEntity)
    }

    data class UIProductListState(
         val loading: Boolean = false,
         val characterResult: CharacterResult? = null,
         val navigateTo: CharacterEntity? = null
    )
}