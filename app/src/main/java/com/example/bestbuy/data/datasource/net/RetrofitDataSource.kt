package com.example.bestbuy.data.datasource.net


import com.example.bestbuy.data.models.CharacterEntity
import com.example.bestbuy.data.models.ProductDetailEntity
import com.example.bestbuy.data.models.ProductEntity
import com.example.bestbuy.data.models.toCharacterEntity
import com.example.core_data.utils.BASE_URL
import com.example.core_data.RetrofitController
import com.example.core_data.RetrofitController.unwrapResponse
import com.example.core_data.RetrofitController.unwrapResponseSingle


class RetrofitDataSource: NetDataSource {

    private var remoteServices: CharacterApi

    init {
        RetrofitController.createConnection(BASE_URL)
        remoteServices = RetrofitController.createRequest(BASE_URL)
    }

    override suspend fun getCharacters(): CharacterEntity? {
        return remoteServices.getCharacters("1", "410d8d5ca72063c4ea4f60b06b35dd18", "ccf46ba5aef281916dd1cb68d61d8116")
                    .unwrapResponseSingle {
                        this.toCharacterEntity()
                    }
    }
}