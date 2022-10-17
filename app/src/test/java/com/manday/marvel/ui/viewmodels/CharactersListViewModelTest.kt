package com.manday.marvel.ui.viewmodels

import android.app.Application
import com.manday.marvel.data.models.CharacterEntity
import com.manday.marvel.di.testModule
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
import org.koin.android.ext.koin.androidContext
import org.koin.core.logger.Level
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.mock.MockProviderRule
import org.koin.test.mock.declareMock
import org.mockito.Mockito
import org.mockito.kotlin.whenever

@OptIn(ExperimentalCoroutinesApi::class)
internal class CharactersListViewModelTest : KoinTest {

    private val context: Application = Mockito.mock(Application::class.java)
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

    // This rule is needed to start koin di for the whole test
    @get:Rule
    val koinTestRule = KoinTestRule.create {
        printLogger(Level.DEBUG)
        androidContext(context)
        modules(testModule)
    }

    // This rule is needed to mock the dependencies which are injected
    @get:Rule
    val mockProvider = MockProviderRule.create { clazz ->
        Mockito.mock(clazz.java)
    }

    @Test
    fun `Loading state works`() = runBlocking {
        val mockCharacterRepository = declareMock<CharacterRepository>()

        whenever(mockCharacterRepository.getCharacters())
            .thenReturn(emptyFlow())

        charactersListViewModel = CharactersListViewModel()

        assertEquals(true, charactersListViewModel.productListState.value.loading)
    }

   @Test
   fun `when getCharacters is called a get a success response`() = runTest {
       val mockCharacterRepository = declareMock<CharacterRepository>()

       whenever(mockCharacterRepository.getCharacters())
           .thenReturn(flow { emit(CharacterResult.SuccessfullResult(listOfCharacters)) })

       // Load the task in the ViewModel
       charactersListViewModel = CharactersListViewModel()

       // Execute pending coroutine actions. Wait until coroutine in stockViewModel.refresh() complete
       advanceUntilIdle()

       val currentGameUiState = charactersListViewModel.productListState.value
       assertEquals(listOfCharacters.size, (currentGameUiState.characterResult as CharacterResult.SuccessfullResult).listCharacterResult.size)
   }

    @Test
    fun `when getCharacters is called a get a wrong response`() = runTest {
        val mockCharacterRepository = declareMock<CharacterRepository>()

        whenever(mockCharacterRepository.getCharacters())
            .thenReturn(flow { emit(CharacterResult.WrongResult) })

        // Load the task in the ViewModel
        charactersListViewModel = CharactersListViewModel()

        // Execute pending coroutine actions. Wait until coroutine in stockViewModel.refresh() complete
        advanceUntilIdle()

        val currentGameUiState = charactersListViewModel.productListState.value
        assertEquals(currentGameUiState.characterResult, CharacterResult.WrongResult)
    }
}