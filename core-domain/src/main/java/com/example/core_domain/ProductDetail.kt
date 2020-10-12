package com.example.core_domain

data class ProductDetail (
    var name: String?,
    var brand: String?,
    var description: String?,
    var price: Int?,
    var currency: String?,
    var discountPercentage: Int?,
    var stock: Int?
)