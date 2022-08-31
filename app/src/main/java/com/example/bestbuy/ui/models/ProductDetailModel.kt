package com.example.bestbuy.ui.models

data class ProductDetailModel(
    val name: String? = null,
    val brand: String? = null,
    val description: String? = null,
    val price: Float? = 0F,
    val currency: String? = null,
    val discountPrice: String? = null,
    val available: Boolean = false,
    val discount: Boolean = false,
    val showImageDiscount: Boolean = false
)
