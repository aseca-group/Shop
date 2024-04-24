package org.example.product

/*
    qty es el peso del producto, si qty < 0.0 entonces el producto es por unidad.
    Por eso inicializo por defecto la cantidad -1.0
 */
class Price(
    val value: Double,
    val isUnit: Boolean,
    val qty: Double? = null,
) {
}