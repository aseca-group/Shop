package com.walle.route

import com.walle.handlers.service.OrderService
import com.walle.models.OrderForm
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

private val orderService = OrderService()

fun Route.orderRoutes() {
    route("/order") {
        get("/{userId}") {
            val userId = call.parameters["userId"]

            if (userId == null) call.respond(HttpStatusCode.BadRequest)
            else {
                try {
                    val chart = orderService.getOrders(userId.toInt())
                    call.respond(HttpStatusCode.OK, chart)
                } catch (e: Exception) {
                    call.respond(HttpStatusCode.BadRequest, e.message.toString())
                }
            }
        }
        post {
            val form = call.receive<OrderForm>()

            try {
                orderService.generateOrder(form)
                call.respond(HttpStatusCode.OK)
            } catch (e: Exception) {
                call.respond(HttpStatusCode.BadRequest, e.message.toString())
            }
        }
    }

}