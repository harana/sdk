package com.harana.sdk.shared.models.flow.actiontypes.transform

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.flow.actiontypes.{ActionTypeGroup, logGroup}
import com.harana.sdk.shared.models.flow.{ActionTypeInfo, Port}

class SelectColumnsInfo extends ActionTypeInfo {

  val id = "10202394-E5BA-4873-A188-68984E738A49"

  val tags = Set()
  val group = ActionTypeGroup.Transform
  val inputPorts = List(Port.DataFrame("in"))
  val outputPorts = List(Port.DataFrame("out"))

  val columnsParameter = Parameter.StringList("columns", required = true)
  val parameterGroups = List(ParameterGroup("general", List(columnsParameter)), logGroup)

}