package com.walle.handlers.request

import com.walle.exceptions.InvalidDataException
import com.walle.models.Order
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*

private const val url = "http://order"

suspend fun getOrdersById(userId: Int): List<Order> {
    val client = HttpClient()

    try {
        val response = client.get(url) {
            url {
                parameters.append("userId", userId.toString())
            }
        }

        if (response.status != HttpStatusCode.OK) throw InvalidDataException("Invalid parameters")
        return response.body<List<Order>>()
    } catch (e: Exception) {
        throw e
    } finally {
        client.close()
    }
}

suspend fun sendOrder(order: Order) {
    val client = HttpClient()

    try {
        val response = client.post(url)

        if (response.status != HttpStatusCode.OK) throw InvalidDataException("Invalid parameters for the order")
    } catch (e: Exception) {
        throw e
    } finally {
        client.close()
    }
}