package com.example.bestbuy.repository

import androidx.lifecycle.LiveData
import com.example.bestbuy.data.datasource.ProductDataSource
import com.example.bestbuy.mapper.toProduct
import com.example.core_data.transformationsMapNotNull

class ProductRepositoryImpl(
    private val netProductDataSource: ProductDataSource
) : ProductRepository {

    override fun getProducts() =
        transformationsMapNotNull(netProductDataSource.getProductList()) {
            it?.map { productEntity ->
                productEntity.toProduct()
            }
        }
}