package com.example.core_domain

data class ProductDetail (
    var name: String?,
    var brand: String?,
    var description: String?,
    var price: Float?,
    var currency: String?,
    var discountPercentage: Int?,
    var discountPrice: Float?,
    var stock: Int?,
    var showImageDiscount: Boolean = false
)