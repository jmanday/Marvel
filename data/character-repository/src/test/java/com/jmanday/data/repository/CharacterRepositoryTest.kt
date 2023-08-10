package com.jmanday.data.repository

import com.jmanday.character_repository.BuildConfig
import com.jmanday.data.provider.mD5Provider
import com.jmanday.domain.repository.CharacterRepository
import com.jmanday.domain.test.character
import com.jmanday.remotedatasource.api.CharacterApi
import com.jmanday.remotedatasource.test.FakeCharacterApi
import com.jmanday.remotedatasource.test.characterResponseDto

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class CharacterRepositoryTest {

    private val mockkApi = mockk<CharacterApi>()
    private lateinit var characterRepository: CharacterRepository

    @Before
    fun provideCharacterRepository() {
        characterRepository = InternalCharacterRepository(api = mockkApi)
    }

    @Test
    fun givenGetCharacterListUseCase_whenCalling_thenReturnListCharacters() = runTest {
        coEvery { mockkApi.getCharacters(any(), any(), any(), any()) } returns characterResponseDto

        val res = characterRepository.getCharacters().first().first()

        coVerify (exactly = 1) { mockkApi.getCharacters(any(), any(), any(), any()) }

        Assert.assertTrue(res.id == characterResponseDto.data.results.first().id)
    }
}