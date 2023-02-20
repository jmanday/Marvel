package com.manday.marvel.domain.repository

import com.manday.marvel.data.datasource.net.models.CharacterEntity
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {

    suspend fun getCharacters(): Flow<CharacterResult>
}

sealed class CharacterResult {
    class SuccessfullResult(val listCharacterResult: List<CharacterEntity>) : CharacterResult()
    object WrongResult : CharacterResult()
}