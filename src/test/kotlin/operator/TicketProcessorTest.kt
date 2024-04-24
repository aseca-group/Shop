package operator

import org.example.builder.ProductBuilderImpl
import org.example.builder.TicketProcessorBuilderImpl
import org.example.product.Price
import org.example.structure.Chart
import org.example.structure.payment.Payment
import org.example.structure.payment.PaymentImpl
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.test.assertFails


class TicketProcessorTest {
    private val ticketProcessor = TicketProcessorBuilderImpl().build()
    private val cost = Price(
        3.1,
        true,
        4.5,
    )
    private val productBuilder = ProductBuilderImpl()

    private fun createPayment(cardNumber: String, bank: String): Payment {
        return PaymentImpl(
            cardNumber,
            bank,
        )
    }

    @Test
    fun test001_ShopWithEmptyChart() {
        val chart = Chart()
        val payment = createPayment("23", "Santander")
        assertFails {
            ticketProcessor.processTicket(chart, payment, 23L)
        }
    }

    @Test
    fun test002_ShopWithWithChart() {
        val products = listOf(
            productBuilder.build("Berenjena", 20.0,0.5, cost, false),
            productBuilder.build("Jirafa", 70.0, cost = cost, isUnit = true),
            productBuilder.build("Lomo", 23.0, 1.0, cost, false),
            productBuilder.build("Shampoo", 50.0, cost = cost, isUnit = true),
            productBuilder.build("Cebolla", 10.0, 1.5, cost = cost, isUnit = false),
            productBuilder.build("Azucar por Peso", 5.0, 3.0, cost = cost, false),
        )
        val chart = Chart(products)
        val payment = createPayment("23", "Santander")
        val ticket = ticketProcessor.processTicket(chart, payment, 23L)
        val total = ticket.total
        assertEquals(total, 183.0)
    }
}