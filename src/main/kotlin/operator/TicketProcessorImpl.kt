package org.example.operator

import org.example.InvalidTicketProcess
import org.example.product.Code
import org.example.product.Product
import org.example.structure.Chart
import org.example.structure.Ticket
import org.example.structure.payment.Payment

class TicketProcessorImpl(
    private val shopCalculator: ShopCalculator,
) : TicketProcessor {

    override fun processTicket(chart: Chart, payment: Payment, userId: Long): Ticket {
        val total = getTotal(chart.getProducts())
        return createTicket(
            chart.getProducts(),
            userId,
            payment,
            total
        )
    }

    private fun createTicket(products: List<Product>, userId: Long, payment: Payment, total: Double): Ticket {
        val productsCode = mutableListOf<Code>()
        products.forEach { p -> productsCode.add(p.code) }
        return Ticket(
            productsCode.toList(),
            userId,
            payment,
            total,
        )
    }

    private fun getTotal(products: List<Product>): Double {
        return when {
            products.isNotEmpty() -> shopCalculator.calculateTotal(products)
            else -> throw InvalidTicketProcess(
                "You chart is EMPTY, please add things to chart (:"
            )
        }

    }
}
