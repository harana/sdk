package com.harana.sdk.shared.models.common

import enumeratum.{CirceEnum, Enum, EnumEntry}
import io.circe.generic.JsonCodec

sealed trait ParameterGroupLayout extends EnumEntry
case object ParameterGroupLayout extends Enum[ParameterGroupLayout] with CirceEnum[ParameterGroupLayout] {
  case object List extends ParameterGroupLayout
  case object Grid extends ParameterGroupLayout
  val values = findValues
}

@JsonCodec
case class ParameterGroup(name: String, parameters: List[Parameter], layout: ParameterGroupLayout = ParameterGroupLayout.List)