package com.harana.sdk.shared.models.flow.actiontypes.query

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.flow.actiontypes.{ActionTypeGroup, logGroup}
import com.harana.sdk.shared.models.flow.{ActionTypeInfo, Port}

class ExecuteSQLInfo extends ActionTypeInfo {

  val id = "D569049B-765E-4A3B-9E66-A5FEB51D35EA"

  val tags = Set()
  val group = ActionTypeGroup.Query
  val inputPorts = List(Port.DataFrame("in"))
  val outputPorts = List(Port.DataFrame("out"))

  val queryParameter = Parameter.String("query", multiLine = true, required = true)
  val viewNameParameter = Parameter.String("view-name", required = true)
  val parameterGroups = List(ParameterGroup("general", List(queryParameter, viewNameParameter)), logGroup)

}