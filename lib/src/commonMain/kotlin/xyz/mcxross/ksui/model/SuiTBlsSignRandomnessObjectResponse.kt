package xyz.mcxross.ksui.model

import kotlinx.serialization.Serializable
import org.gciatto.kt.math.BigInteger

@Serializable data class SuiTBlsSignRandomnessObjectResponse(val signature: BigInteger)