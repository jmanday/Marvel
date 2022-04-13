package com.example.bestbuy.repository

import com.example.bestbuy.data.datasource.ProductDataSource
import com.example.bestbuy.mapper.toProduct
import com.example.bestbuy.mapper.toProductDetail
import com.example.core_data.utils.transformationsMapNotNull
import com.example.core_domain.Product
import com.example.core_domain.ProductDetail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class ProductRepositoryImpl(
    private val netProductDataSource: ProductDataSource
) : ProductRepository {

    override suspend fun getProducts(): Flow<List<Product>?> {
        return flow {
            emit(netProductDataSource.getProductList()?.map { it.toProduct() })
        }.flowOn(Dispatchers.IO)
    }


    override fun getProductById(idProduct: Int): Flow<ProductDetail?> {
        return flow {
            emit(netProductDataSource.getProductById(idProduct)?.toProductDetail())
        }.flowOn(Dispatchers.IO)
    }
}