package org.example.structure

import org.example.product.Code
import org.example.structure.payment.Payment

class Ticket(
    private val productsCode: List<Code>,
    private val clientId: Long,
    private val payment: Payment,
    private val total: Double
) {

}