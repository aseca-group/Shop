package org.example.builder

import org.example.product.Code
import org.example.product.Price
import org.example.product.Product

class ProductBuilderImpl : ProductBuilder{
    override fun build(name: String, value: Double, qty: Double, cost: Price, isUnit: Boolean): Product {
        return when {
            isUnit -> Product(
                name,
                Price(value, true),
                cost,
                Code(),
            )
            else -> Product(
                name,
                Price(value, false, qty),
                cost,
                Code(),
            )
        }
    }
}
