package discount

import org.example.discount.product.TwoForOne
import org.example.product.Code
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import java.util.*

class DiscountTest {

    @Test
    fun test001_TwoForOneOddProductsQuantity() {
        val productDiscountedCode = UUID.randomUUID()
        val discount = TwoForOne(
            10L,
            listOf(
                Code(productDiscountedCode)
            ),
            from = LocalDateTime.of(2024, 4, 6,0,0),
            to = LocalDateTime.of(3000, 4,8,0,0),
        )
        val codesFormChart = listOf(
            productDiscountedCode,
            UUID.randomUUID(),
            UUID.randomUUID(),
            productDiscountedCode
        )
    }

    @Test
    fun test002_TwoForOneEvenProductsQuantity() {
        val productDiscountedCode = UUID.randomUUID()
        val discount = TwoForOne(
            10L,
            listOf(
                Code(productDiscountedCode)
            ),
            from = LocalDateTime.of(2024, 4, 10,0,0),
            to = LocalDateTime.of(3000, 23,6,0,0),
        )
        val codesFormChart = listOf(
            productDiscountedCode,
            UUID.randomUUID(),
            UUID.randomUUID(),
            productDiscountedCode,
            productDiscountedCode
        )
    }

    @Test
    fun test003_TwoForOneInvalidDate() {
        val productDiscountedCode = UUID.randomUUID()
        val discount = TwoForOne(
            10L,
            listOf(
                Code(productDiscountedCode)
            ),
            from = LocalDateTime.of(2024, 4, 6,0,0),
            to = LocalDateTime.of(2024, 4,8,0,0),
        )
        val codesFormChart = listOf(
            productDiscountedCode,
            UUID.randomUUID(),
            UUID.randomUUID(),
            productDiscountedCode,
            productDiscountedCode
        )
    }
}