package com.harana.sdk.shared.models.flow.actiontypes.transform

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.flow.actiontypes.{ActionTypeGroup, logGroup}
import com.harana.sdk.shared.models.flow.{ActionTypeInfo, Port}

class DeduplicateInfo extends ActionTypeInfo {

  val id = "C1F29250-2572-4AA6-82A9-658FA8237FF0"

  val tags = Set()
  val group = ActionTypeGroup.Transform
  val inputPorts = List(Port.DataFrame("in"))
  val outputPorts = List(Port.DataFrame("out"))

  val columnsParameter = Parameter.StringList("columns")
  val parameterGroups = List(ParameterGroup("general", List(columnsParameter)), logGroup)

}