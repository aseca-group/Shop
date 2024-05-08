package com.walle.handlers.request

import com.walle.exceptions.InvalidDataException
import com.walle.models.Cart
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*

private const val url = "http://control/cart"

suspend fun getCartByUserId(userId: Int): Cart {
    val client = HttpClient()

    try {
        val response = client.get(url) {
            url {
                parameters.append("userId", userId.toString())
            }
        }

        if (response.status != HttpStatusCode.OK) throw InvalidDataException("Invalid parameters")
        return response.body<Cart>()
    } catch (e: Exception) {
        throw e
    } finally {
        client.close()
    }
}

suspend fun updateCartWithProduct(userId: Int, productId: Int, action: String) {
    val client = HttpClient()
    val target = "$url/$action"

    try {
        val response = client.put(target) {
            contentType(ContentType.Application.Json)
            url {
                parameters.append("userId", userId.toString())
                parameters.append("productId", productId.toString())
            }
        }

        if(response.status != HttpStatusCode.OK) throw InvalidDataException("Invalid parameters")
    } catch (e: Exception) {
        throw e
    } finally {
        client.close()
    }
}

suspend fun emptyCartByUserId(userId: Int) {
    val client = HttpClient()
    val target = "$url/empty"

    try {
        val response = client.put(target) {
            contentType(ContentType.Application.Json)
        }

        if (response.status != HttpStatusCode.OK) throw InvalidDataException("Invalid parameters")
    } catch (e: Exception) {
         throw e
    } finally {
        client.close()
    }
}
