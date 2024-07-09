package com.harana.sdk.shared.models.features.chronon

import enumeratum._

sealed trait TimeUnit extends EnumEntry

object TimeUnit extends Enum[TimeUnit] with CirceEnum[TimeUnit] {
  case object HOURS extends TimeUnit
  case object DAYS extends TimeUnit
  val values = findValues
}