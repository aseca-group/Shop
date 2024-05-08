package com.walle.handlers.processor

import com.walle.models.Cart
import com.walle.models.Order
import com.walle.models.OrderForm
import com.walle.models.Product
import java.time.LocalDateTime

class OrderProcessorImpl(
    private val shopCalculator: ShopCalculator,
) : OrderProcessor {
    override fun processOrder(orderForm: OrderForm, cart: Cart): Order {
        val total = shopCalculator.calculateTotal(cart.products)
        return Order(
            getProductsId(cart.products),
            orderForm.address_id,
            orderForm.customer_id,
            orderForm.card_id,
            total,
            LocalDateTime.now()
        )
    }

    private fun getProductsId(products: List<Product>): List<Int> {
        val productsId = mutableListOf<Int>()
        products.forEach {
            p -> productsId.add(p.id)
        }
        return productsId.toList()
    }
}
