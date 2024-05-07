package com.walle.handlers.service

import com.walle.handlers.request.getProductById
import com.walle.models.Product

class ProductService {

    suspend fun getProduct(productId: Int): Product {
        return getProductById(productId)
    }

}