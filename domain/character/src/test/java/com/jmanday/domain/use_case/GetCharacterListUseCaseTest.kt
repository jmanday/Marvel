package com.jmanday.domain.use_case

import com.jmanday.domain.repository.CharacterRepository
import com.jmanday.domain.test.character

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest

import org.junit.Test
import org.junit.Assert.*
import org.junit.Before


@OptIn(ExperimentalCoroutinesApi::class)
class GetCharacterListUseCaseTest {

    private val mockCharacterRepository = mockk<CharacterRepository>()
    private lateinit var getCharacterListUseCase: GetCharacterListUseCase

    @Before
    fun provideGetCharacterListUseCase() {
        getCharacterListUseCase = GetCharacterListUseCase(repository = mockCharacterRepository)
    }

    @Test
    fun givenGetCharacterListUseCase_whenCalling_thenReturnListCharacters() = runTest {
        coEvery { mockCharacterRepository.getCharacters() } returns flow { emit(listOf(character, character)) }

        val markets = getCharacterListUseCase().first()

        coVerify { mockCharacterRepository.getCharacters() }
        assertTrue(markets.size == 2)
    }

}