package com.walle.handlers.processor

import com.walle.models.Cart
import com.walle.models.Ticket

interface TicketProcessor {
    fun processTicket(chart: Cart, userId: Int): Ticket
}