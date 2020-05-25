package dev.acaica.server.net.types

class Trade(
        val inputItem1: SlotData,
        val outputItem: SlotData,
        val hasSecondItem: Boolean,
        val inputItem2: SlotData?,
        val tradeDisabled: Boolean,
        val numberOfTradeUses: Int,
        val maximalNumberOfTradeUses: Int,
        val xp: Int,
        val specialPrice: Int,
        val priceMultiplier: Float,
        val demand: Int
)
