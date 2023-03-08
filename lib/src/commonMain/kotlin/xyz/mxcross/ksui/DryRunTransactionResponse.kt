package xyz.mxcross.ksui

import kotlinx.serialization.Serializable

@Serializable
data class DryRunTransactionResponse(val effects: TransactionEffects, val events: List<Event>)
