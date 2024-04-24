package org.example.discount

import org.example.product.Code

interface Discount {

    fun getDiscount(clientProducts: List<Code>): Double
}