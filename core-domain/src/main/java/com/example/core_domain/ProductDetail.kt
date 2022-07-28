package com.example.core_domain

data class ProductDetail (
    var name: String? = null,
    var brand: String? = null,
    var description: String? = null,
    var price: Float? = null,
    var currency: String? = null,
    var discountPercentage: Int? = null,
    var discountPrice: Float? = null,
    var stock: Int? = null,
    var showImageDiscount: Boolean = false
)