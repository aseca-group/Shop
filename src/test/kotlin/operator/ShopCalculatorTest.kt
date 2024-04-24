package operator

import org.example.operator.ShopCalculator
import org.example.product.Code
import org.example.product.Price
import org.example.product.Product
import kotlin.test.Test
import kotlin.test.assertEquals

class ShopCalculatorTest {
    val shopCalculator = ShopCalculator()
    val cost = Price(
        3.1,
        true,
        4.5,
    )

    private fun createProduct(name: String, value: Double, qty: Double = 0.0, isUnit: Boolean): Product {
        return when {
            isUnit -> Product(
                name,
                Price(value, true),
                cost,
                Code(),
            )
            else -> Product(
                name,
                Price(value, false, qty),
                cost,
                Code(),
            )
        }
    }

    @Test
    fun test001_ShopCalculatorCalculateTotalForUnityProducts() {
        val products = listOf(
            createProduct("berenjena", 23.0, 0.5, false),
            createProduct("cuadril", 50.0, 1.0, false),
            createProduct("choclo", 20.0, 1.5, false),
            createProduct("banana", 10.5, 0.5, false),
        )
        val total = shopCalculator.calculateTotal(products)
        assertEquals(total, 96.75)
    }
}