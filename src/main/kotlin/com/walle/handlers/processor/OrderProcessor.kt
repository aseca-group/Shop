package com.walle.handlers.processor

import com.walle.models.Cart
import com.walle.models.Order
import com.walle.models.OrderForm

interface OrderProcessor {
    fun processOrder(orderForm: OrderForm, cart: Cart): Order
}