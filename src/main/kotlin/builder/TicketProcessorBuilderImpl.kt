package org.example.builder

import org.example.operator.ShopCalculator
import org.example.operator.ShopCalculatorImpl
import org.example.operator.TicketProcessor
import org.example.operator.TicketProcessorImpl

class TicketProcessorBuilderImpl : TicketProcessorBuilder{
    override fun build(): TicketProcessor {
        return TicketProcessorImpl(
            getCalculator(),
        )
    }

    private fun getCalculator(): ShopCalculator {
        return ShopCalculatorImpl()
    }
}