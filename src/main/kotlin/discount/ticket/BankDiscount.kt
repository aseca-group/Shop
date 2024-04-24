package org.example.discount.ticket

import org.example.Card.CardType
import org.example.discount.TicketDiscount
import org.example.product.Code
import org.example.structure.Ticket

class BankDiscount (
    private val bank: String,
    private val cardType: CardType
) : TicketDiscount {
    override fun hasDiscount(ticket: Ticket): Boolean {
        TODO("Not yet implemented")
    }

    override fun getDiscount(clientProducts: List<Code>): Double {
        TODO("Not yet implemented")
    }
}