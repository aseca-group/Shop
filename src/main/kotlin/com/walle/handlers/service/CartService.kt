package com.walle.handlers.service

import com.walle.handlers.request.emptyCartByUserId
import com.walle.handlers.request.getCartByUserId
import com.walle.handlers.request.updateCartWithProduct
import com.walle.models.Cart

class CartService : Service {

    suspend fun getCart(userId: Int): Cart {
        return getCartByUserId(userId)
    }

    suspend fun updateCart(userId: Int, productId: Int, add: Boolean = true) {
        when {
            add -> updateCartWithProduct(userId, productId, "add")
            else -> updateCartWithProduct(userId, productId, "remove")
        }
    }

    suspend fun emptyCart(userId: Int) {
        return emptyCartByUserId(userId)
    }
}