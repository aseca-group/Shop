package com.walle.handlers.request

import com.walle.models.Cart
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*

private const val url = "http://control/cart"

suspend fun getCartFormTower(userId: Int): Cart {
    val client = HttpClient()

    try {
        val response = client.get(url) {
            url {
                parameters.append("userId", userId.toString())
            }
        }
        return response.body<Cart>()
    } catch (e: Exception) {
        println("Error al obtener el carrito de la torre de control: ${e.message}")
        throw e
    } finally {
        client.close()
    }
}

suspend fun addItemToCart(userId: Int, productId: Int) {
    val client = HttpClient()

    try {
        val response = client.put(url) {
            contentType(ContentType.Application.Json)
            url {
                parameters.append("userId", userId.toString())
                parameters.append("productId", productId.toString())
            }
        }

        if (response.status == HttpStatusCode.OK) {
            println("Carrito actualizado en la torre de control")
        } else {
            println("Error al actualizar el carrito en la torre de control. Código de estado: ${response.status}")
        }
    } catch (e: Exception) {
        println("Error al actualizar el carrito en la torre de control: ${e.message}")
        throw e
    } finally {
        client.close()
    }
}
