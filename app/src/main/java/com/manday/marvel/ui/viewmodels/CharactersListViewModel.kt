package com.manday.marvel.ui.viewmodels

import androidx.lifecycle.*

import com.manday.marvel.data.datasource.net.models.CharacterEntity
import com.manday.marvel.domain.repository.CharacterRepository
import com.manday.marvel.domain.repository.CharacterResult

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CharactersListViewModel @Inject constructor(
    private val characterRepository: CharacterRepository
): ViewModel() {

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