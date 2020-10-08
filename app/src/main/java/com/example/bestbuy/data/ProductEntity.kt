package com.example.bestbuy.data

import com.google.gson.annotations.SerializedName

data class ProductEntity(

    @SerializedName("id")
    var id: Int? = null,

    @SerializedName("name")
    var name: String,

    @SerializedName("brand")
    var brand: String,

    @SerializedName("price")
    var price: Int,

    @SerializedName("currency")
    var currency: String,

    @SerializedName("image")
    var image: String,

    @SerializedName("_link")
    var _link: String,

    @SerializedName("_type")
    var _type: String
)