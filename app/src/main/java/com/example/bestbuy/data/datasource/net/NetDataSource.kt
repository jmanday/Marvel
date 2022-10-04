package com.example.bestbuy.data.datasource.net

import com.example.bestbuy.data.models.CharacterEntity

interface NetDataSource {

    suspend fun getCharacters(): List<CharacterEntity>?
}