package com.walle.route

import com.walle.handlers.service.OrderService
import io.ktor.server.routing.*

private val orderService = OrderService()

fun Route.orderRoutes() {
    route("/order") {
        get("/order/{userId}") {

        }
        post("/order") {

        }
    }

}