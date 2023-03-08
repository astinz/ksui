package xyz.mxcross.ksui

import kotlinx.serialization.Serializable

@Serializable
data class DevInspectResults(
  val effects: List<TransactionEffect>,
  val events: List<Event>,
  val results: List<Array<Pair<UInt, SuiExecutionResultOrString>>>
)
