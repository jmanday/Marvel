package com.example.bestbuy.data.datasource

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.bestbuy.data.ProductResponseEntity
import com.example.bestbuy.data.datasource.net.ProductApi
import com.example.core_data.RetrofitController
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteProductDataSource : ProductDataSource {

    private var remoteServices: ProductApi?

    init {
        RetrofitController.createConnection(BASE_URL)
        remoteServices = RetrofitController.createRequest(BASE_URL)
    }

    override fun getProductList(): LiveData<List<String>?> {
        val data = MutableLiveData<List<String>?>()
        val call = remoteServices?.getProducts(AUTHORIZATION)

        call?.enqueue(object : Callback<List<ProductResponseEntity>> {
            override fun onFailure(call: Call<List<ProductResponseEntity>>, t: Throwable) {
                data.value = null
            }

            override fun onResponse(
                call: Call<List<ProductResponseEntity>>,
                response: Response<List<ProductResponseEntity>>
            ) {
                data.value = listOf()
            }

        })

        return data
    }

    companion object {
        private const val BASE_URL = "https://bestsecret-recruitment-api.herokuapp.com/products"
        private const val AUTHORIZATION = "ddf49ca9-44cf-4613-b218-ddc030bbfa63"
    }
}