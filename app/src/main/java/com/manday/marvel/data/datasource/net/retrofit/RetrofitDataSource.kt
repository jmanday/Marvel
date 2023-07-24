package com.manday.marvel.data.datasource.net.retrofit


import com.manday.core_data.utils.BASE_URL
import com.manday.core_data.RetrofitController
import com.manday.marvel.data.datasource.NetDataSource
import com.manday.marvel.data.datasource.net.models.CharacterEntity
import javax.inject.Inject


class RetrofitDataSource @Inject constructor() : NetDataSource {

    private var remoteServices: String

    init {
        RetrofitController.createConnection(BASE_URL)
        remoteServices = RetrofitController.createRequest(BASE_URL)
    }

    override suspend fun getCharacters(hashCode: String): List<CharacterEntity> {
        //TODO
        return emptyList()
    }
}