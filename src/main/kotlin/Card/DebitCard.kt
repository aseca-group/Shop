package org.example.Card

class DebitCard(
    val bank: String,
    val number: String,
    val balance: Double
): Card {
    override fun hasFunds(amount: Double): Boolean {
        return balance > 0
    }

    override fun getStatus(): Double{
        return balance
    }
}