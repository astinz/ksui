package xyz.mcxross.ksui.model.serializer

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonEncoder
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import xyz.mcxross.ksui.model.MoveFunctionParameter

object MoveNormalizedFunctionParameterSerializer : KSerializer<MoveFunctionParameter> {
  override val descriptor: SerialDescriptor =
    PrimitiveSerialDescriptor("MoveFunctionParameter", PrimitiveKind.STRING)
  override fun serialize(encoder: Encoder, value: MoveFunctionParameter) {
    require(encoder is JsonEncoder)
  }

  override fun deserialize(decoder: Decoder): MoveFunctionParameter {
    require(decoder is JsonDecoder)
    return when (val jsonElement = decoder.decodeJsonElement()) {
      is JsonObject -> {
        if (jsonElement.containsKey("MutableReference")) {
          MoveFunctionParameter.MutableReference()
        } else if (jsonElement.containsKey("Struct")) {
          val struct = jsonElement["Struct"]?.jsonObject
          MoveFunctionParameter.Struct(
            struct?.get("address")?.jsonPrimitive?.content ?: "",
            struct?.get("module")?.jsonPrimitive?.content ?: "",
            struct?.get("name")?.jsonPrimitive?.content ?: ""
          )
        } else if (jsonElement.containsKey("Vector")) {
          if (jsonElement["Vector"] is JsonObject) {
            MoveFunctionParameter.Vector(
              if (jsonElement["Vector"]?.jsonObject?.containsKey("U8") == true) {
                MoveFunctionParameter.U8()
              } else if (jsonElement["Vector"]?.jsonObject?.containsKey("U64") == true) {
                MoveFunctionParameter.U64()
              } else if (jsonElement["Vector"]?.jsonObject?.containsKey("U128") == true) {
                MoveFunctionParameter.U128()
              } else if (jsonElement["Vector"]?.jsonObject?.containsKey("U256") == true) {
                MoveFunctionParameter.U256()
              } else {
                MoveFunctionParameter.Undefined()
              }
            )
          } else if (jsonElement["Vector"] is JsonPrimitive) {
            MoveFunctionParameter.Undefined()
          } else {
            MoveFunctionParameter.Undefined()
          }
        } else {
          MoveFunctionParameter.Undefined()
        }
      }
      is JsonPrimitive -> {
        if (jsonElement.isString) {
          when (jsonElement.jsonPrimitive.content) {
            "Address" -> {
              MoveFunctionParameter.Address()
            }
            "U64" -> {
              MoveFunctionParameter.U64()
            }
            else -> {
              MoveFunctionParameter.Undefined()
            }
          }
        } else {
          MoveFunctionParameter.Undefined()
        }
      }
      else -> {
        MoveFunctionParameter.Undefined()
      }
    }
  }
}
