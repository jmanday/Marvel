package com.manday.marvel.domain.repository

import com.manday.marvel.data.datasource.db.LocalDataSource
import com.manday.marvel.data.datasource.net.NetDataSource
import com.manday.marvel.data.models.CharacterEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class InternalCharacterRepository(
    private val netNetDataSource: NetDataSource,
    private val localDataSource: LocalDataSource
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

    override suspend fun getCharacters(): Flow<List<CharacterEntity>?> {
        return flow {
            emit( netNetDataSource.getCharacters())
        }.flowOn(Dispatchers.IO)
    }
}