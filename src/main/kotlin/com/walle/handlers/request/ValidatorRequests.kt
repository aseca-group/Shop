package com.walle.handlers.request

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*

private const val url = "http://control/verify"

suspend fun userExistsById(userId: Int): Boolean {
    val client = HttpClient()
    val target = "$url/coustomer"

    try {
        val response = client.get(target) {
            url {
                parameter("userId", userId)
            }
        }

        return when (response.status) {
            HttpStatusCode.OK -> true // El usuario existe
            HttpStatusCode.NotFound -> false // El usuario no existe
            else -> throw RuntimeException("Error by status: ${response.status}")
        }
    } catch (e: Exception) {
        println("Server error: ${e.message}")
        throw e
    } finally {
        client.close()
    }
}

suspend fun addressExistsById(addressId: Int): Boolean {
    val client = HttpClient()
    val target = "$url/address"

    try {
        val response = client.get(target) {
            url{
                parameter("addressId", addressId)
            }
        }

        return when (response.status) {
            HttpStatusCode.OK -> true
            HttpStatusCode.NotFound -> false
            else -> throw RuntimeException("Error by status: ${response.status}")
        }
    } catch (e: Exception) {
        println("Server error: ${e.message}")
        throw e
    } finally {
        client.close()
    }
}

suspend fun cardExistsById(cardId: Int): Boolean {
    val client = HttpClient()
    val target = "$url/card"

    try {
        val response = client.get(target) {
            url{
                parameter("cardId", cardId)
            }
        }

        return when (response.status) {
            HttpStatusCode.OK -> true
            HttpStatusCode.NotFound -> false
            else -> throw RuntimeException("Error by status: ${response.status}")
        }
    } catch (e: Exception) {
        println("Server error: ${e.message}")
        throw e
    } finally {
        client.close()
    }
}
