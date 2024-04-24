package org.example.operator

import org.example.product.Product

interface ShopCalculator {
    fun calculateTotal(products: List<Product>): Double
}