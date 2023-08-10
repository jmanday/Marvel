package com.jmanday.characterlist

import androidx.lifecycle.*
import com.jmanday.domain.use_case.GetCharacterListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel


import javax.inject.Inject


@HiltViewModel
class CharactersListViewModel @Inject constructor(
    private val getCharacterListUseCase: GetCharacterListUseCase
): ViewModel() {


}