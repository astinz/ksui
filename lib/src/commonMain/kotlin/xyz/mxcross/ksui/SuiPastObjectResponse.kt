package xyz.mxcross.ksui

import kotlinx.serialization.Serializable

@Serializable data class SuiPastObjectResponse(val status: String, val details: Details)
