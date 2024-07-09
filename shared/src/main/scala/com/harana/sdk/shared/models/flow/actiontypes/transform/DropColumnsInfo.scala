package com.harana.sdk.shared.models.flow.actiontypes.transform

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.flow.actiontypes.{ActionTypeGroup, logGroup}
import com.harana.sdk.shared.models.flow.{ActionTypeInfo, Port}

class DropColumnsInfo extends ActionTypeInfo {

  val id = "030F76BA-5A2D-4FDA-9D8C-EA083FA02D89"

  val tags = Set()
  val group = ActionTypeGroup.Transform
  val inputPorts = List(Port.DataFrame("in"))
  val outputPorts = List(Port.DataFrame("out"))

  val columnsParameter = Parameter.StringList("columns", required = true)
  val parameterGroups = List(ParameterGroup("general", List(columnsParameter)), logGroup)

}