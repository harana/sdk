package com.harana.sdk.shared.models.flow.actiontypes.transform

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.flow.actiontypes.{ActionTypeGroup, logGroup}
import com.harana.sdk.shared.models.flow.{ActionTypeInfo, Port}

class StandardiseColumnNamesInfo extends ActionTypeInfo {

  val tags = Set()
  val group = ActionTypeGroup.Transform
  val inputPorts = List(Port.DataFrame("in"))
  val outputPorts = List(Port.DataFrame("out"))

  val columnsParameter = Parameter.StringList("columns", required = true)
  val generalGroup = ParameterGroup("general", List(columnsParameter))

  val parameterGroups = List(generalGroup, logGroup)

}