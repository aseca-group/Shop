package com.walle.handlers.request

import com.walle.models.Chart
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*

private const val url = "http://control/chart"

suspend fun getChartFormTower(user_id: Int): Chart {
    val client = HttpClient()

    try {
        val response = client.get(url) {
            url {
                parameters.append("user_id", user_id.toString())
            }
        }
        return response.body<Chart>()
    } catch (e: Exception) {
        println("Error al obtener el carrito de la torre de control: ${e.message}")
        throw e
    } finally {
        client.close()
    }
}

suspend fun addItemToChart(user_id: Int, product_id: Int) {
    val client = HttpClient()

    try {
        val response = client.put(url) {
            contentType(ContentType.Application.Json)
            url {
                parameters.append("user_id", user_id.toString())
                parameters.append("product_id", product_id.toString())
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
