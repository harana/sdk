package com.harana.sdk.shared.models.flow

import com.harana.sdk.shared.models.common.ParameterGroup
import com.harana.sdk.shared.models.flow.actiontypes.{ActionTypeGroup, ActionTypes}
import io.circe.{Decoder, Encoder}
import cats.syntax.either._

trait ActionTypeInfo {
  val id: ActionTypeInfo.Id
  val tags: Set[String]
  val group: ActionTypeGroup
  val inputPorts: List[Port]
  val outputPorts: List[Port]
  val parameterGroups: List[ParameterGroup]
  val mode: ActionMode = ActionMode.Normal
}

object ActionTypeInfo {
  type Id = String

  implicit def decodeActionTypeInfo[A <: ActionTypeInfo]: Decoder[A] =
    Decoder.decodeString.emap { str => Either.catchNonFatal(ActionTypes.get(str).asInstanceOf[A]).leftMap(e => { e.printStackTrace(); "" } )}

  implicit def encodeActionTypeInfo[A <: ActionTypeInfo]: Encoder[A] =
    Encoder.encodeString.contramap[A](_.id)
}