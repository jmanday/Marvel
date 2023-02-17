package com.manday.marvel.domain.repository

import android.util.Log
import com.manday.marvel.BuildConfig
import com.manday.marvel.MarvelCharactersApp
import com.manday.marvel.data.datasource.LocalDataSource
import com.manday.marvel.data.datasource.NetDataSource
import com.manday.marvel.data.datasource.db.models.toListCharacterEntity
import com.manday.marvel.data.datasource.db.room.RoomDataSource
import com.manday.marvel.data.datasource.net.models.toListMarvelCharacter
import com.manday.marvel.domain.mD5Provider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class InternalCharacterRepository @Inject constructor(
    private val netNetDataSource: NetDataSource,
    private val localDataSource: LocalDataSource
) : CharacterRepository {

    override suspend fun getCharacters(): Flow<CharacterResult> {
        return flow {
            lateinit var result: CharacterResult
            val localMarvelCharacter = localDataSource.getCharacters()

            result = if (localMarvelCharacter.isEmpty()) {
                val callResult = netNetDataSource.getCharacters(mD5Provider.getMD5(BuildConfig.HASH_KEY))
                if (callResult.isNullOrEmpty()) CharacterResult.WrongResult else {
                    val marvelCharacterList = callResult.filter { !it.thumbnailPath.contains("image_not_available".toRegex()) }
                    localDataSource.saveCharacters(marvelCharacterList.toListMarvelCharacter())
                    CharacterResult.SuccessfullResult(marvelCharacterList)
                }
            } else {
                CharacterResult.SuccessfullResult(localMarvelCharacter.toListCharacterEntity())
            }

            emit(result)
        }.flowOn(Dispatchers.IO)
    }
}