package org.example.discount

import org.example.structure.Ticket

interface TicketDiscount: Discount {
    fun hasDiscount(ticket: Ticket): Boolean
}