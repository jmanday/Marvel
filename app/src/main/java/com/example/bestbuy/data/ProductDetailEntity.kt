package com.example.bestbuy.data

import com.google.gson.annotations.SerializedName

data class ProductDetailEntity(

    @SerializedName("description")
    var description: String? = null,

    @SerializedName("discountPercentage")
    var discountPercentage: Int? = null,

    @SerializedName("stock")
    var stock: Int? = null

): ProductEntity()