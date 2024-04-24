package card

import org.example.Card.CreditCard
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class CreditCardTest {

    @Test
    fun checkCreditBalance(){
        val card = CreditCard("Santander", 20000.0, 20.0)
        assertTrue(card.hasFunds(10000.0))
    }

    @Test
    fun creditHasNoFunds(){
        val card = CreditCard("BBVA", 20000.0, 15000.0)
        assertFalse(card.hasFunds(10000.0))
    }
}