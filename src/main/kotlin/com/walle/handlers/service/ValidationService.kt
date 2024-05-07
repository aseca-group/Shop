package com.walle.handlers.service

import com.walle.models.OrderForm

class ValidationService() : Service {

    fun validate_order(form: OrderForm): Boolean {
        return true
    }
}