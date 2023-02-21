package com.manday.marvel.ui.viewmodels

import android.app.Application
import com.manday.marvel.data.datasource.net.models.CharacterEntity
import com.manday.marvel.domain.repository.CharacterRepository
import com.manday.marvel.domain.repository.CharacterResult
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.whenever

@OptIn(ExperimentalCoroutinesApi::class)
internal class CharactersListViewModelTest {

    private val context: Application = mock(Application::class.java)
    private val mockCharacterRepository = mock(CharacterRepository::class.java)
    private lateinit var charactersListViewModel: CharactersListViewModel

    private val listOfCharacters = listOf(
        CharacterEntity("name_1", "description_1", "thumbnail_1"),
        CharacterEntity("name_2", "description_2", "thumbnail_2"),
        CharacterEntity("name_3", "description_3", "thumbnail_3"),
        CharacterEntity("name_4", "description_4", "thumbnail_4"),
        CharacterEntity("name_5", "description_5", "thumbnail_5")
    )

    // This rule is needed to set StandardTestDispatcher as main Dispatcher, in order to avoid run in main Looper
    @get:Rule
    var mainDispatcherRule = MainDispatcherRule()

    @Test
    fun `Loading state works`() = runBlocking {
        whenever(mockCharacterRepository.getCharacters())
            .thenReturn(emptyFlow())

        charactersListViewModel = CharactersListViewModel(mockCharacterRepository)

        assertEquals(true, charactersListViewModel.state.value.loading)
    }

   @Test
   fun `when getCharacters is called a get a success response`() = runTest {
       whenever(mockCharacterRepository.getCharacters())
           .thenReturn(flow { emit(CharacterResult.SuccessfullResult(listOfCharacters)) })

       // Load the task in the ViewModel
       charactersListViewModel = CharactersListViewModel(mockCharacterRepository)

       // Execute pending coroutine actions. Wait until coroutine in stockViewModel.refresh() complete
       advanceUntilIdle()

       val currentGameUiState = charactersListViewModel.state.value
       assertEquals(listOfCharacters.size, (currentGameUiState.characterResult as CharacterResult.SuccessfullResult).listCharacterResult.size)
   }

    @Test
    fun `when getCharacters is called a get a wrong response`() = runTest {
        whenever(mockCharacterRepository.getCharacters())
            .thenReturn(flow { emit(CharacterResult.WrongResult) })

        // Load the task in the ViewModel
        charactersListViewModel = CharactersListViewModel(mockCharacterRepository)

        // Execute pending coroutine actions. Wait until coroutine in stockViewModel.refresh() complete
        advanceUntilIdle()

        val currentGameUiState = charactersListViewModel.state.value
        assertEquals(currentGameUiState.characterResult, CharacterResult.WrongResult)
    }
}