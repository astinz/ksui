package xyz.mxcross.ksui

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable data class AddressOwner(@SerialName("AddressOwner") val address: SuiAddress)
