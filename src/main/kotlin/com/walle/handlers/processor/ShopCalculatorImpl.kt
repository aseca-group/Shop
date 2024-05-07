package com.walle.handlers.processor

import com.walle.models.Product

class ShopCalculatorImpl : ShopCalculator {

    override fun calculateTotal(products: List<Product>): Double {
        var total = 0.0
        products.forEach {
            p -> total += calculatePrice(p)
        }
        return total
    }

    private fun calculatePrice(product: Product): Double {
        val isUnit = product.price.isUnit
        return when {
            isUnit -> calculatePriceByUnit(product)
            else -> calculatePriceByWeight(product)
        }
    }

    private fun calculatePriceByWeight(product: Product): Double {
        return product.price.value * product.price.qty!!
    }

    private fun calculatePriceByUnit(product: Product): Double {
        return product.price.value
    }
}