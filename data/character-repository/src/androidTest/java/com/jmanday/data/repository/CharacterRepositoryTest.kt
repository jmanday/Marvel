package com.jmanday.data.repository


import com.jmanday.domain.repository.CharacterRepository
import com.jmanday.domain.test.character
import com.jmanday.remotedatasource.test.FakeCharacterApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before


@OptIn(ExperimentalCoroutinesApi::class)
class CharacterRepositoryTest {

    private val api = FakeCharacterApi()
    private lateinit var characterRepository: CharacterRepository

    @Before
    fun initialise() {
        characterRepository = InternalCharacterRepository(api)
    }

    @Test
    fun testing() {
        assertTrue(true)
    }

    @Test
    @Throws(Exception::class)
    fun getCharacters() = runTest {

        val result = characterRepository.getCharacters().first().first()
        assertTrue(result == character)
    }
}