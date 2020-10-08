package com.example.bestbuy.data

import com.google.gson.annotations.SerializedName

data class ProductResponseEntity(

    @SerializedName("list")
    var productList: List<ProductEntity>,

    @SerializedName("page")
    var page: Int,

    @SerializedName("pageSize")
    var pageSize: Int,

    @SerializedName("size")
    var size: Int,

    @SerializedName("_link")
    var _link: String,

    @SerializedName("_type")
    var _type: String,

    @SerializedName("_next")
    var _next: String
)