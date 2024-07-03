package com.harana.sdk.shared.models.flow.actiontypes.transform

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.flow.actiontypes.ActionTypeGroup
import com.harana.sdk.shared.models.flow.{ActionTypeInfo, Port}

class RepartitionInfo extends ActionTypeInfo {

  val tags = Set()
  val group = ActionTypeGroup.Transform
  val inputPorts = List(Port.DataFrame("in"))
  val outputPorts = List(Port.DataFrame("out"))

  val partitionCountParameter = Parameter.Integer("partition-count", required = true)
  val parameterGroups = List(ParameterGroup("general", List(partitionCountParameter)))

}