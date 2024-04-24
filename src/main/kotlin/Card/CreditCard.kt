package org.example.Card

class CreditCard(
    val bank: String,
    val number: String,
    val top: Double,
    val actual: Double
): Card {

    override fun hasFunds(amount: Double): Boolean {
        return (amount + actual) < top
    }

    override fun getStatus(): Double{
        return top - actual
    }
}