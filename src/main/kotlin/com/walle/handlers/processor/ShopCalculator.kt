package com.walle.handlers.processor

import com.walle.models.Product

interface ShopCalculator {
    fun calculateTotal(products: List<Product>): Double
}