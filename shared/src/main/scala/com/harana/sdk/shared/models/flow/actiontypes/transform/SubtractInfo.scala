package com.harana.sdk.shared.models.flow.actiontypes.transform

import com.harana.sdk.shared.models.flow.actiontypes.{ActionTypeGroup, logGroup}
import com.harana.sdk.shared.models.flow.{ActionTypeInfo, Port}

class SubtractInfo extends ActionTypeInfo {

  val tags = Set()
  val group = ActionTypeGroup.Transform
  val inputPorts = List(Port.DataFrame("left-in"), Port.DataFrame("right-in"))
  val outputPorts = List(Port.DataFrame("out"))
  val parameterGroups = List(logGroup)

}
