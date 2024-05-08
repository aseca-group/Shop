package com.walle.route

import com.walle.handlers.service.CartService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

private val cartService = CartService()

fun Route.cartRoutes() {
    route("/cart") {
        get("/{userId}") {
            val userId = call.parameters["userId"]

            if (userId == null) call.respond(HttpStatusCode.BadRequest)
            else {
                try {
                    val chart = cartService.getCart(userId.toInt())
                    call.respond(HttpStatusCode.OK, chart)
                } catch (e: Exception) {
                    call.respond(HttpStatusCode.BadRequest, e.message.toString())
                }
            }
        }
        put("/add/{userId}/{productId}") {
            val userId = call.parameters["userId"]
            val productId = call.parameters["productId"]

            if (userId == null || productId == null) call.respond(HttpStatusCode.BadRequest)
            else {
                try {
                    cartService.updateCart(userId.toInt(), productId.toInt())
                    call.respond(HttpStatusCode.OK)
                } catch (e: Exception) {
                    call.respond(HttpStatusCode.BadRequest, e.message.toString())
                }
            }
        }
        put("/remove/{userId}/{productId}") {
            val userId = call.parameters["userId"]
            val productId = call.parameters["productId"]

            if (userId == null || productId == null) call.respond(HttpStatusCode.BadRequest)
            else {
                try {
                    cartService.updateCart(userId.toInt(), productId.toInt(), false)
                    call.respond(HttpStatusCode.OK)
                } catch (e: Exception) {
                    call.respond(HttpStatusCode.BadRequest, e.message.toString())
                }
            }
        }
        put("/empty/{userId}") {
            val userId = call.parameters["userId"]

            if(userId == null) call.respond(HttpStatusCode.BadRequest)
            else {
                try {
                    cartService.emptyCart(userId.toInt())
                    call.respond(HttpStatusCode.OK)
                } catch (e: Exception) {
                    call.respond(HttpStatusCode.BadRequest, e.message.toString())
                }
            }
        }
    }
}
