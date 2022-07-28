package com.example.bestbuy.data.datasource.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Product(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String?,
    val brand: String?,
    val price: Int?,
    val currency: String?,
    val image: String?
)