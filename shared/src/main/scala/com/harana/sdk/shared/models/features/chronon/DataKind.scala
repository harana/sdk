package com.harana.sdk.shared.models.features.chronon

import enumeratum._
import io.circe.generic.JsonCodec

sealed trait DataKind extends EnumEntry

object DataKind extends Enum[DataKind] with CirceEnum[DataKind] {
  case object BOOLEAN extends DataKind
  case object BYTE extends DataKind
  case object SHORT extends DataKind
  case object INT extends DataKind
  case object LONG extends DataKind
  case object FLOAT extends DataKind
  case object DOUBLE extends DataKind
  case object STRING extends DataKind
  case object BINARY extends DataKind
  case object DATE extends DataKind
  case object TIMESTAMP extends DataKind
  case object MAP extends DataKind
  case object LIST extends DataKind
  case object STRUCT extends DataKind

  val values = findValues
}

