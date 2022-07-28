package com.example.bestbuy.data

import com.google.gson.annotations.SerializedName

open class ProductEntity {
    var id: Int = 0
    var name: String? = null
    var brand: String? = null
    var price: Int? = null
    var currency: String? = null
    var image: String? = null

    @SerializedName("_link")
    var link: String? = null

    @SerializedName("_type")
    var type: String? = null
}