package com.manday.marvel.data.datasource.net.retrofit


import com.manday.core_data.utils.BASE_URL
import com.manday.core_data.RetrofitController
import com.manday.core_data.RetrofitController.unwrapResponse
import com.manday.marvel.BuildConfig
import com.manday.marvel.data.datasource.NetDataSource
import com.manday.marvel.data.datasource.net.api.CharacterApi
import com.manday.marvel.data.datasource.net.models.CharacterEntity
import com.manday.marvel.data.datasource.net.models.toCharacterEntityList
import javax.inject.Inject


class RetrofitDataSource @Inject constructor() : NetDataSource {

    private var remoteServices: CharacterApi

    init {
        RetrofitController.createConnection(BASE_URL)
        remoteServices = RetrofitController.createRequest(BASE_URL)
    }

    override suspend fun getCharacters(hashCode: String): List<CharacterEntity>? {
        return remoteServices.getCharacters(BuildConfig.TS, BuildConfig.PUBLIC_KEY, hashCode)
                    .unwrapResponse {
                        this.toCharacterEntityList()
                    }
    }
}