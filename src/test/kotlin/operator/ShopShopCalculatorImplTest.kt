package operator

import org.example.operator.ShopCalculatorImpl
import org.example.product.Code
import org.example.product.Price
import org.example.product.Product
import kotlin.test.Test
import kotlin.test.assertEquals

class ShopShopCalculatorImplTest {
    val shopCalculatorImpl = ShopCalculatorImpl()
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
    fun test001_ShopCalculatorCalculateTotalForWeightedProducts() {
        val products = listOf(
            createProduct("berenjena", 23.0, 0.5, false),
            createProduct("cuadril", 50.0, 1.0, false),
            createProduct("choclo", 20.0, 1.5, false),
            createProduct("banana", 10.5, 0.5, false),
        )
        val total = shopCalculatorImpl.calculateTotal(products)
        assertEquals(total, 96.75)
    }

    @Test
    fun test002_ShopCalculatorCalculateTotalForUnityProducts() {
        val products = listOf(
            createProduct("Galletita de manteca", 20.0, isUnit = true),
            createProduct("Galletita de agua", 10.0, isUnit = true),
            createProduct("Galletita Terrabusi", 15.0, isUnit = true),
        )
        val total = shopCalculatorImpl.calculateTotal(products)
        assertEquals(total, 45.0)
    }

    @Test
    fun test003_ShopCalculatorCalculateTotalForUnityAndWeightedProducts() {
        val products = listOf(
            createProduct("berenjena", 23.0, 0.5, false),
            createProduct("cuadril", 50.0, 1.0, false),
            createProduct("Galletita de manteca", 20.0, isUnit = true),
            createProduct("Galletita de agua", 10.0, isUnit = true),
            createProduct("choclo", 20.0, 1.5, false),
            createProduct("banana", 10.5, 0.5, false),
            createProduct("Galletita Terrabusi", 15.0, isUnit = true),
        )
        val total = shopCalculatorImpl.calculateTotal(products)
        assertEquals(total, 141.75)
    }
}