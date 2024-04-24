package org.example.discount.product

import org.example.discount.ProductDiscount
import org.example.product.Code
import java.time.LocalDateTime

class ThreeForTwo(
    val id: Long,
    val productsCode: List<Code>,
    val from: LocalDateTime,
    val to: LocalDateTime
): ProductDiscount {

    override fun getDiscount(clientProducts: List<Code>): Double {
        var discount = 0.0
        if(onDate()){
            for(code in productsCode){
                discount += discount(clientProducts, code)
            }
        }
        return discount
    }

    private fun discount(clientProducts: List<Code>, productCode: Code): Double{
        var discount = 0.0
        var i = 0
        for(c in clientProducts){
            when(c){
                productCode -> {
                    i += 1
                    if(i % 3 == 0){  // do not discount until count 3
                        discount += getPrice(c)
                    }
                }
                else -> continue
            }
        }
        return discount
    }

    private fun onDate(): Boolean{
        val now = LocalDateTime.now()
        return now > from && to > now
    }

    private fun getPrice(code: Code): Double{
        TODO() //Get the product from database??!
    }




}