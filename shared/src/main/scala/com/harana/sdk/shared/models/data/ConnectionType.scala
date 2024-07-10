package com.harana.sdk.shared.models.data

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.ConnectionType.ConnectionTypeId
import enumeratum.values.{StringCirceEnum, StringEnum, StringEnumEntry}

import scala.scalajs.reflect.annotation.EnableReflectiveInstantiation

@EnableReflectiveInstantiation
trait ConnectionType {
  val parameterGroups: List[ParameterGroup]
  val id: ConnectionTypeId
  val syncDirection: SyncDirection
}

object ConnectionType {
  type ConnectionTypeId = String
}


sealed abstract class SyncDirection(val value: String) extends StringEnumEntry
object SyncDirection extends StringEnum[SyncDirection] with StringCirceEnum[SyncDirection] {
  case object Source extends SyncDirection("source")
  case object Destination extends SyncDirection("destination")
  case object Bidirectional extends SyncDirection("bidirectional")
  val values = findValues
}