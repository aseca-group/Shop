package com.walle.handlers.processor

import com.walle.models.Chart
import com.walle.models.Ticket

interface TicketProcessor {
    fun processTicket(chart: Chart, payment: Payment, userId: Int): Ticket
}