package com.manday.marvel.data.datasource.db.room

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import app.cash.turbine.test
import com.manday.marvel.data.datasource.db.models.MarvelCharacter
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.equalTo
import org.junit.*
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
@SmallTest
internal class CharacterDaoTest {

    private lateinit var characterDao: CharacterDao
    private lateinit var database: MarvelDatabase

    @Before
   fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        database = Room
            .inMemoryDatabaseBuilder(context, MarvelDatabase::class.java)
            .build()

        characterDao = database.CharacterDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        database.close()
    }

    @Test
    fun insertAndReadUser() = runBlocking {
        val character = MarvelCharacter(name = "Jesus Manday", description = "Some description")
        characterDao.insertCharacter(character)

        characterDao.getAll().test {
            val list = awaitItem()
            assertThat(list.first(), equalTo(character.copy(id = 1)))
            cancel()
        }
    }
}