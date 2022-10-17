package com.manday.marvel.domain

import java.math.BigInteger
import java.security.MessageDigest

internal fun interface MD5Provider {
    fun getMD5(input: String): String
}

internal val mD5Provider = MD5Provider {
    require(it.isNotEmpty()) {
        "The input can not be empty"
    }

    val md = MessageDigest.getInstance("MD5")
    BigInteger(1, md.digest(it.toByteArray())).toString(16).padStart(32, '0')
}
