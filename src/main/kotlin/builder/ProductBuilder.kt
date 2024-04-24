package org.example.builder

import org.example.product.Price
import org.example.product.Product

interface ProductBuilder {
    fun build(name: String, value: Double, qty: Double = 0.0, cost: Price, isUnit: Boolean): Product
}