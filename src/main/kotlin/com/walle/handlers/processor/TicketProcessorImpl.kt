package com.walle.handlers.processor

import org.example.InvalidTicketProcess
import org.example.product.Product
import org.example.structure.Chart
import org.example.structure.Ticket
import org.example.structure.payment.Payment

class TicketProcessorImpl(
    private val shopCalculator: ShopCalculator,
) : TicketProcessor {

    override fun processTicket(chart: Chart, payment: Payment, userId: Int): Ticket {
        val total = getTotal(chart.getProducts())
        return createTicket(
            chart.getProducts(),
            userId,
            payment,
            total
        )
    }

    private fun createTicket(products: List<Product>, userId: Int, payment: Payment, total: Double): Ticket {
        val products_id = mutableListOf<Int>()
        products.forEach { p -> products_id.add(p.id) }
        return Ticket(
            products_id.toList(),
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
