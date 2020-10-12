package com.example.bestbuy.mapper

import com.example.bestbuy.data.ProductDetailEntity
import com.example.bestbuy.data.ProductEntity
import com.example.core_domain.Product
import com.example.core_domain.ProductDetail

fun ProductEntity.toProduct() =
    Product(id = this.id, name = this.name, image = this.image)

fun ProductDetailEntity.toProductDetail() =
    ProductDetail(name = this.name, brand = this.brand, description = this.description, price = this.price, currency = this.currency, discountPercentage = this.discountPercentage, stock = this.stock)