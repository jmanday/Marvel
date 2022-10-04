package com.manday.marvel.domain.models

data class Product (
    var id: Int?,
    var name: String?,
    var image: String?,
    var selected: Boolean = false
)