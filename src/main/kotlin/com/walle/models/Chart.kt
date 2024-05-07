package com.walle.models

import kotlinx.serialization.Serializable

@Serializable
class Chart(
    val products: List<Product>,
) {
}