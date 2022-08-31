package com.example.bestbuy.data.datasource


import com.example.bestbuy.data.models.ProductDetailEntity
import com.example.bestbuy.data.models.ProductEntity
import com.example.bestbuy.data.datasource.net.ProductApi
import com.example.core_data.utils.BASE_URL
import com.example.core_data.RetrofitController
import com.example.core_data.RetrofitController.unwrapResponse


class RemoteProductDataSource : ProductDataSource {

    private var remoteServices: ProductApi

    init {
        RetrofitController.createConnection(BASE_URL)
        remoteServices = RetrofitController.createRequest(BASE_URL)
    }

    override suspend fun getProductList(): List<ProductEntity>? {
        val result = remoteServices.getProducts()

        return result.unwrapResponse {
            this.productList
        }
    }

    override suspend fun getProductById(idProduct: Int): ProductDetailEntity? {
        val result = remoteServices.getProductsById(idProduct)

        return result.body()
    }
}