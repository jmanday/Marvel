package com.example.bestbuy.mapper

import com.example.bestbuy.data.ProductEntity
import com.example.core_domain.Product

fun ProductEntity.toProduct() =
    Product(id = this.id, name = this.name, image = this.image)