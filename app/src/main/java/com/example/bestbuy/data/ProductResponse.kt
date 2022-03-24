package com.example.bestbuy.data

import com.google.gson.annotations.SerializedName

data class ProductResponse(

    @SerializedName("list")
    var productList: List<ProductEntity>,

    @SerializedName("page")
    var page: Int,

    var pageSize: Int,
    var size: Int,

    @SerializedName("_link")
    var link: String,

    @SerializedName("_type")
    var type: String,

    @SerializedName("_next")
    var next: String
)