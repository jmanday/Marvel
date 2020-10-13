package com.example.bestbuy.mapper

import com.example.bestbuy.Constants.MIN_DISCOUNT
import com.example.bestbuy.data.ProductDetailEntity
import com.example.bestbuy.data.ProductEntity
import com.example.core_domain.Product
import com.example.core_domain.ProductDetail
import java.math.BigDecimal
import java.math.RoundingMode

fun ProductEntity.toProduct() =
    Product(id = this.id, name = this.name, image = this.image)

fun ProductDetailEntity.toProductDetail(): ProductDetail {
    val finalPrice: Float?
    finalPrice = this.discountPercentage?.let {
        val dis = it/100f
        this.price?.let {
            val formatNumber = BigDecimal((it * dis).toDouble())
            formatNumber.setScale(2, RoundingMode.DOWN).toFloat()
        }
    }
    val showDiscountImage = this.discountPercentage?.let {
        it > MIN_DISCOUNT
    } ?: false

    return ProductDetail(
        name = this.name,
        brand = this.brand,
        description = this.description,
        price = this.price?.toFloat(),
        currency = this.currency,
        discountPercentage = this.discountPercentage,
        stock = this.stock,
        showImageDiscount = showDiscountImage,
        discountPrice = finalPrice
    )
}
