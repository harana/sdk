package com.harana.sdk.shared.models.data

import cats.syntax.either._
import com.harana.sdk.shared.models.common.ParameterGroup
import com.harana.sdk.shared.models.data.ConnectionType.ConnectionTypeId
import enumeratum.values.{StringCirceEnum, StringEnum, StringEnumEntry}
import io.circe.{Decoder, Encoder}

import scala.scalajs.reflect.annotation.EnableReflectiveInstantiation

@EnableReflectiveInstantiation
trait ConnectionType {
  val parameterGroups: List[ParameterGroup]
  val id: ConnectionTypeId
  val syncDirection: SyncDirection
}

object ConnectionType {
  type ConnectionTypeId = String

  implicit def decoder[A <: ConnectionType]: Decoder[A] = Decoder.decodeString.emap { str => Either.catchNonFatal(ConnectionTypes.get(str).asInstanceOf[A]).leftMap(e => { e.printStackTrace(); "" } ) }
  implicit def encoder[A <: ConnectionType]: Encoder[A] = Encoder.encodeString.contramap[A](_.id)
}


sealed abstract class SyncDirection(val value: String) extends StringEnumEntry
object SyncDirection extends StringEnum[SyncDirection] with StringCirceEnum[SyncDirection] {
  case object Source extends SyncDirection("source")
  case object Destination extends SyncDirection("destination")
  case object Bidirectional extends SyncDirection("bidirectional")
  val values = findValues
}