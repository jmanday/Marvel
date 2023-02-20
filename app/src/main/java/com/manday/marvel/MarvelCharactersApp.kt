package com.manday.marvel

import android.app.Application
import com.manday.marvel.data.datasource.db.room.MarvelDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MarvelCharactersApp : Application() {

    val database: MarvelDatabase by lazy { MarvelDatabase.getDatabase(this) }

}