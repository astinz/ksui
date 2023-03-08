package xyz.mxcross.ksui

import kotlinx.serialization.Serializable

@Serializable
data class RPCTransactionRequestParams(
  val moveCallRequestParams: MoveCallRequestParams?,
  val transferObjectRequestParams: TransferObjectRequestParams?
)
