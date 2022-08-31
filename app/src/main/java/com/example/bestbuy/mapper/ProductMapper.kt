package com.example.bestbuy.mapper

import com.example.bestbuy.Constants.MIN_DISCOUNT
import com.example.bestbuy.data.models.ProductDetailEntity
import com.example.bestbuy.data.models.ProductEntity
import com.example.bestbuy.domain.models.Product
import com.example.bestbuy.domain.models.ProductDetail
import com.example.bestbuy.ui.models.ProductDetailModel
import com.example.bestbuy.ui.models.ProductModel
import com.example.bestbuy.data.datasource.db.Product as LocalProduct
import java.math.BigDecimal
import java.math.RoundingMode

fun ProductEntity.toProduct() =
    Product(id = this.id, name = this.name, image = this.image)

fun ProductEntity.toLocalProduct() =
    LocalProduct(
        id = this.id,
        name = this.name,
        brand = this.brand,
        price = this.price,
        currency = this.currency,
        image = this.image)

fun LocalProduct.toProduct() =
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

fun ProductDetail.toProductDetailModel() =
    ProductDetailModel(

    )

fun List<Product>?.toListProductModel(): List<ProductModel> {
    if (this == null) return listOf()

    return map {
        ProductModel(
            id = it.id,
            imagePath = it.image
        )
    }
}