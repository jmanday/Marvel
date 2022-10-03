package com.example.bestbuy.domain.repository

import com.example.bestbuy.data.datasource.db.LocalDataSource
import com.example.bestbuy.data.datasource.net.NetDataSource
import com.example.bestbuy.data.models.CharacterEntity
import com.example.bestbuy.domain.models.Product
import com.example.bestbuy.domain.models.ProductDetail
import com.example.bestbuy.mapper.toLocalProduct
import com.example.bestbuy.mapper.toProduct
import com.example.bestbuy.mapper.toProductDetail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class InternalProductRepository(
    private val netNetDataSource: NetDataSource,
    private val localDataSource: LocalDataSource
) : ProductRepository {

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

    override suspend fun getCharacters(): Flow<CharacterEntity?> {
        return flow {
            emit( netNetDataSource.getCharacters())
        }.flowOn(Dispatchers.IO)
    }
}