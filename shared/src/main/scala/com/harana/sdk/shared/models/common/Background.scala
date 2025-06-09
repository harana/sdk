package com.harana.sdk.shared.models.common

import io.circe.{Decoder, Encoder, Json}
import io.circe.generic.auto.*
import org.latestbit.circe.adt.codec.*

enum Background derives JsonTaggedAdt.Decoder, JsonTaggedAdt.Encoder {
  case Gradient(colors: List[String], direction: Option[String] = scala.None)
  case Hex(hex: String)
  case HSL(hue: Double, saturation: Double, lightness: Double, alpha: Double)
  case Image(url: String)
  case RGB(red: Double, green: Double, blue: Double, alpha: Double)
}