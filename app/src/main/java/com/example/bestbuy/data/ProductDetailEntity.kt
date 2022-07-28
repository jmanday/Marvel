package com.example.bestbuy.data

data class ProductDetailEntity(
    var description: String? = null,
    var discountPercentage: Int? = null,
    var stock: Int? = null
): ProductEntity()