package com.walle.handlers.service

import com.walle.exceptions.InvalidDataException
import com.walle.handlers.processor.ShopCalculator
import com.walle.handlers.processor.ShopCalculatorImpl
import com.walle.handlers.request.addressExistsById
import com.walle.handlers.request.cardExistsById
import com.walle.handlers.request.userExistsById
import com.walle.models.Chart
import com.walle.models.OrderForm

class OrderService : Service {

    suspend fun generateOrder(form: OrderForm) {
        validateData(form)
        val total = getTotal(form.chart)

    }

    private suspend fun validateData(form: OrderForm) {
        if (!areValidData(form)) throw InvalidDataException("Se envió información invalida")
    }

    private suspend fun areValidData(form: OrderForm): Boolean {
        return userExistsById(form.customer_id) &&
                cardExistsById(form.customer_id) &&
                addressExistsById(form.address_id)
    }

    private fun getTotal(chart: Chart): Double {
        val products = chart.products
        return ShopCalculatorImpl().calculateTotal(products)
    }
}