package com.walle.models

import kotlinx.serialization.Serializable
import org.example.product.Price

@Serializable
class Product (
    val id: Int,
    val price: Price,
    ) {
}