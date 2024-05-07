package com.walle.models

import kotlinx.serialization.Serializable

@Serializable
class Ticket (
    val products_id: List<Int>,
    val client_id: Int,
    val payment: Payment,
    val total: Double,){
}