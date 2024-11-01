package com.harana.sdk.shared.models.features.chronon

import enumeratum._

sealed trait Accuracy extends EnumEntry

object Accuracy extends Enum[Accuracy] with CirceEnum[Accuracy] {
  case object SNAPSHOT extends Accuracy
  case object TEMPORAL extends Accuracy

  val values = findValues
}