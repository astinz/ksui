package xyz.mxcross.ksui

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable data class Digest(@SerialName("digest") val value: String)
