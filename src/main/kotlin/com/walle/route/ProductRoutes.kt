package com.walle.route

import com.walle.exceptions.InvalidDataException
import com.walle.handlers.service.ProductService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

private val productService = ProductService()

fun Route.productRoutes() {
    route("/product") {
        get("/{id}") {
            val productId = call.parameters["id"]

            if (productId == null) call.respond(HttpStatusCode.BadRequest)
            else {
                try {
                    val product = productService.getProduct(productId.toInt())
                    call.respond(HttpStatusCode.OK, product)
                } catch (e: InvalidDataException) {
                    call.respond(HttpStatusCode.BadRequest, e.message.toString())
                }
            }
        }
    }
}
