package com.example.core_domain

import java.io.Serializable

data class Product (
    var id: Int?,
    var name: String?,
    var image: String?,
    var selected: Boolean = false
) : Serializable