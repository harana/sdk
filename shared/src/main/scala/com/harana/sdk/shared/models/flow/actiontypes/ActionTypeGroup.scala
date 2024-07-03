package com.harana.sdk.shared.models.flow.actiontypes

import enumeratum.{CirceEnum, Enum, EnumEntry}

sealed trait ActionTypeGroup extends EnumEntry
case object ActionTypeGroup extends Enum[ActionTypeGroup] with CirceEnum[ActionTypeGroup] {
  case object Info extends ActionTypeGroup
  case object Input extends ActionTypeGroup
  case object Output extends ActionTypeGroup
  case object Query extends ActionTypeGroup
  case object Search extends ActionTypeGroup
  case object Transform extends ActionTypeGroup
  val values = findValues
}
