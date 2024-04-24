package org.example.builder

import org.example.operator.TicketProcessor

interface TicketProcessorBuilder {
    fun build(): TicketProcessor
}