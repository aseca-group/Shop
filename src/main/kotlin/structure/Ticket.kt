package org.example.structure

import org.example.product.Code
import org.example.structure.payment.Payment

class Ticket(
    val productsCode: List<Code>,
    val clientId: Long,
    val payment: Payment,
    val total: Double
) {
}