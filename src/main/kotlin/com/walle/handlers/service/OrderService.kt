package com.walle.handlers.service

import com.walle.exceptions.InvalidDataException
import com.walle.handlers.processor.OrderProcessorImpl
import com.walle.handlers.processor.ShopCalculatorImpl
import com.walle.handlers.request.*
import com.walle.models.Cart
import com.walle.models.Order
import com.walle.models.OrderForm

private val orderProcessor = OrderProcessorImpl(ShopCalculatorImpl())

class OrderService : Service {

    suspend fun generateOrder(form: OrderForm): Order {
        validateData(form)
        val cart = getCartByUserId(form.customer_id)
        return orderProcessor.processOrder(form, cart)
    }

    suspend fun getOrders(userId: Int): List<Order> {
        userExistsById(userId)
        return getOrdersById(userId)
    }

    private suspend fun validateData(form: OrderForm) {
        if (!areValidData(form)) throw InvalidDataException("Se envió información invalida")
    }

    private suspend fun areValidData(form: OrderForm): Boolean {
        return userExistsById(form.customer_id) &&
                cardExistsById(form.customer_id) &&
                addressExistsById(form.address_id)
    }

    private fun getTotal(chart: Cart): Double {
        val products = chart.products
        return ShopCalculatorImpl().calculateTotal(products)
    }
}