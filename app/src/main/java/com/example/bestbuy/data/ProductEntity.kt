package com.example.bestbuy.data

import com.google.gson.annotations.SerializedName

data class ProductEntity(

    @SerializedName("id")
    var id: Int? = null,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("brand")
    var brand: String? = null,

    @SerializedName("price")
    var price: Int? = null,

    @SerializedName("currency")
    var currency: String? = null,

    @SerializedName("image")
    var image: String? = null,

    @SerializedName("_link")
    var _link: String? = null,

    @SerializedName("_type")
    var _type: String? = null
)