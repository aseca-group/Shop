package com.walle.models

import java.time.LocalDateTime

class Order(
    val productsId: List<Int>,
    val addressIds: Int,
    val customerId: Int,
    val cardId: Int,
    val total: Double,
    val date: LocalDateTime,
) {
}