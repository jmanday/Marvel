package com.example.bestbuy.repository

import com.example.bestbuy.data.datasource.db.LocalDataSource
import com.example.bestbuy.data.datasource.net.NetDataSource
import com.example.bestbuy.mapper.toLocalProduct
import com.example.bestbuy.mapper.toProduct
import com.example.bestbuy.mapper.toProductDetail
import com.example.core_domain.Product
import com.example.core_domain.ProductDetail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class InternalProductRepository(
    private val netNetDataSource: NetDataSource,
    private val localDataSource: LocalDataSource
) : ProductRepository {

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


    override fun getProductById(idProduct: Int): Flow<ProductDetail?> {
        return flow {
            emit(netNetDataSource.getProductById(idProduct)?.toProductDetail())
        }.flowOn(Dispatchers.IO)
    }
}