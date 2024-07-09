package com.harana.sdk.shared.models.features.chronon

import enumeratum._
import io.circe.generic.JsonCodec

sealed trait Operation extends EnumEntry

object Operation extends Enum[Operation] with CirceEnum[Operation] {
  case object MIN extends Operation
  case object MAX extends Operation
  case object FIRST extends Operation
  case object LAST extends Operation
  case object APPROX_UNIQUE_COUNT extends Operation
  case object UNIQUE_COUNT extends Operation
  case object COUNT extends Operation
  case object SUM extends Operation
  case object AVERAGE extends Operation
  case object VARIANCE extends Operation
  case object SKEW extends Operation
  case object KURTOSIS extends Operation
  case object APPROX_PERCENTILE extends Operation
  case object LAST_K extends Operation
  case object FIRST_K extends Operation
  case object TOP_K extends Operation
  case object BOTTOM_K extends Operation
  case object HISTOGRAM extends Operation
  case object APPROX_HISTOGRAM_K extends Operation

  val values = findValues
}

