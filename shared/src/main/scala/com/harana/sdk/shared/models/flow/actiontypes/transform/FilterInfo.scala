package com.harana.sdk.shared.models.flow.actiontypes.transform

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.flow.actiontypes.{ActionTypeGroup, logGroup}
import com.harana.sdk.shared.models.flow.{ActionTypeInfo, Port}

class FilterInfo extends ActionTypeInfo {

  val id = "13335B50-1991-4C98-9BCC-DEA38DB6EC80"

  val tags = Set()
  val group = ActionTypeGroup.Transform
  val inputPorts = List(Port.DataFrame("in"))
  val outputPorts = List(Port.DataFrame("out"))

  val conditionParameter = Parameter.String("condition", required = true)
  val parameterGroups = List(ParameterGroup("general", List(conditionParameter)), logGroup)

}