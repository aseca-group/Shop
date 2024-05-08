package com.walle.handlers.request

import com.walle.exceptions.InvalidDataException
import com.walle.models.Product
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*

private const val url = "http://control/product"

suspend fun getProductById(productId: Int): Product {
    val client = HttpClient()

    try {
        val response = client.get(url) {
            url {
                parameters.append("productId", productId.toString())
            }
        }

        if (response.status != HttpStatusCode.OK) throw InvalidDataException("Product not found")
        return response.body<Product>()
    } catch (e: Exception) {
        println("Error al obtener el carrito de la torre de control: ${e.message}")
        throw e
    } finally {
        client.close()
    }
}
