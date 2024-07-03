package com.harana.sdk.shared.models.flow.actiontypes.transform

import com.harana.sdk.shared.models.flow.actiontypes.ActionTypeGroup
import com.harana.sdk.shared.models.flow.{ActionTypeInfo, Port}

class ForkInfo extends ActionTypeInfo {

  val tags = Set()
  val group = ActionTypeGroup.Transform
  val inputPorts = List(Port.DataFrame("in"))
  val outputPorts = List(Port.DataFrameList("out"))
  val parameterGroups = List()

}