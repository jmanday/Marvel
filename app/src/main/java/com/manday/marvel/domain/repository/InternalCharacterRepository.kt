package com.manday.marvel.domain.repository

import com.manday.marvel.BuildConfig
import com.manday.marvel.data.datasource.LocalDataSource
import com.manday.marvel.data.datasource.NetDataSource
import com.manday.marvel.domain.mD5Provider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class InternalCharacterRepository @Inject constructor(
    private val netNetDataSource: NetDataSource
) : CharacterRepository {

    /*
    override suspend fun getProducts(): Flow<List<Product>?> {
        return flow {
            if (localDataSource.getProducts().isEmpty()) {
                val products = netNetDataSource.getProductList()?.map { it.toLocalProduct() }
                products?.let {
                    localDataSource.saveProducts(it)
                }
            }

            emit(localDataSource.getProducts().map { it.toProduct() })
        }.flowOn(Dispatchers.IO)
    }
*/

    override suspend fun getCharacters(): Flow<CharacterResult> {
        return flow {
            val callResult = netNetDataSource.getCharacters(mD5Provider.getMD5(BuildConfig.HASH_KEY))
            val result = if (callResult.isNullOrEmpty()) CharacterResult.WrongResult else CharacterResult.SuccessfullResult(
                callResult.filter { !it.thumbnailPath.contains("image_not_available".toRegex()) })
            emit(result)
        }.flowOn(Dispatchers.IO)
    }
}