package org.example.operator

import org.example.structure.Chart
import org.example.structure.Ticket
import org.example.structure.payment.Payment

interface TicketProcessor {
    fun processTicket(chart: Chart, payment: Payment, userId: Long): Ticket
}