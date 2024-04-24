package org.example.structure

import org.example.product.Product

class Chart(
    private val productList: List<Product> = emptyList()
) {

    fun clean(): Chart{
        return Chart()
    }

    fun isEmpty(): Boolean{
        return productList.isEmpty()
    }

    fun getProducts(): List<Product>{
        return productList
    }

    fun addProduct(p: Product): Chart{
        val mutList = productList.toMutableList()
        mutList.addFirst(p)
        return Chart(mutList.toList())
    }
}