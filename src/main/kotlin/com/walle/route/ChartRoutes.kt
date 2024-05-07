package com.walle.route

import io.ktor.server.routing.*

fun Route.chartRoutes() {
    route("/chart") {
        get("/chart/{user_id}") {
            //request for user's chart
        }
        put("/chart/{user_id}/{product_id}") {
            //request to add product
        }
    }
}