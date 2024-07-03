package com.harana.sdk.shared.models.flow.actiontypes.input

import com.harana.sdk.shared.models.flow.actiontypes.ActionTypeGroup
import com.harana.sdk.shared.models.flow.{ActionTypeInfo, Port}

abstract class InputActionTypeInfo extends ActionTypeInfo {
  val group = ActionTypeGroup.Input
  val inputPorts = List()
  val outputPorts = List(Port.DataFrame("out"))
}