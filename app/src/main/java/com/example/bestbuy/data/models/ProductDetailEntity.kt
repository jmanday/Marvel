package com.example.bestbuy.data.models

data class ProductDetailEntity(
    var description: String? = null,
    var discountPercentage: Int? = null,
    var stock: Int? = null
): ProductEntity()