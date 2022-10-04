package com.example.bestbuy.data.datasource.net


import com.example.bestbuy.data.models.*
import com.example.core_data.utils.BASE_URL
import com.example.core_data.RetrofitController
import com.example.core_data.RetrofitController.unwrapResponse


class RetrofitDataSource: NetDataSource {

    private var remoteServices: CharacterApi

    init {
        RetrofitController.createConnection(BASE_URL)
        remoteServices = RetrofitController.createRequest(BASE_URL)
    }

    override suspend fun getCharacters(): List<CharacterEntity>? {
        return remoteServices.getCharacters("1", "410d8d5ca72063c4ea4f60b06b35dd18", "ccf46ba5aef281916dd1cb68d61d8116")
                    .unwrapResponse {
                        this.toCharacterEntityList()
                    }
    }
}