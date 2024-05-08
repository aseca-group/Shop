package com.walle.models

import kotlinx.serialization.Serializable

@Serializable
class Cart(
    val products: List<Product>,
) {
}