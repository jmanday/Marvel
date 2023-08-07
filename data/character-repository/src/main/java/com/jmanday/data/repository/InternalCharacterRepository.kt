package com.jmanday.data.repository

import com.jmanday.character_repository.BuildConfig
import com.jmanday.data.mapper.toCharacterList
import com.jmanday.data.provider.mD5Provider
import com.jmanday.domain.model.Character
import com.jmanday.domain.repository.CharacterRepository
import com.jmanday.remotedatasource.api.CharacterApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class InternalCharacterRepository @Inject constructor(
    private val api: CharacterApi
) : CharacterRepository {

    override suspend fun getCharacters(): Flow<List<Character>>  = flow {
        val result = api.getCharacters(BuildConfig.TS, BuildConfig.PUBLIC_KEY, hashCode = mD5Provider.getMD5(BuildConfig.HASH_KEY)).toCharacterList()
        emit(result)
    }
}