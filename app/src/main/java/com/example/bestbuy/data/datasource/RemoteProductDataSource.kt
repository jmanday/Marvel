package com.example.bestbuy.data.datasource

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.bestbuy.data.ProductEntity
import com.example.bestbuy.data.ProductResponse
import com.example.bestbuy.data.datasource.net.ProductApi
import com.example.core_data.utils.BASE_URL
import com.example.core_data.RetrofitController
import com.example.core_data.RetrofitController.unwrapResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteProductDataSource : ProductDataSource {

    private var remoteServices: ProductApi?

    init {
        RetrofitController.createConnection(BASE_URL)
        remoteServices = RetrofitController.createRequest(BASE_URL)
    }

    override fun getProductList(): LiveData<List<ProductEntity>?> {
        val data = MutableLiveData<List<ProductEntity>?>()
        val call = remoteServices?.getProducts()

        call?.enqueue(object : Callback<ProductResponse> {
            override fun onResponse(
                call: Call<ProductResponse>,
                response: Response<ProductResponse>
            ) {
                data.value = response.unwrapResponse {
                    this.productList
                }
            }

            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                data.value = null
            }
        })

        return data
    }
}