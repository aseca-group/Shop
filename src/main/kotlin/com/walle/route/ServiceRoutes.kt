package com.walle.route

import com.walle.models.OrderForm
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.routing.*


fun Route.ticketRoutes() {
    route("/shop"){
        post("/buy") {
            val chart = call.receive<OrderForm>()

        }
    }
}
