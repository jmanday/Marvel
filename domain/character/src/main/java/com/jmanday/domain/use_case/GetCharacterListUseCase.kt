package com.jmanday.domain.use_case

import com.jmanday.domain.model.Character
import com.jmanday.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCharacterListUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    suspend operator fun invoke(): Flow<List<Character>> = repository.getCharacters()
}