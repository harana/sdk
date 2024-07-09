package com.harana.sdk.shared.models.flow.actiontypes.transform

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.flow.actiontypes.{ActionTypeGroup, logGroup}
import com.harana.sdk.shared.models.flow.{ActionTypeInfo, Port}

class TransposeInfo extends ActionTypeInfo {

  val id = "CD902E78-FD15-4327-A1C6-0A03979ED943"

  val tags = Set()
  val group = ActionTypeGroup.Transform
  val inputPorts = List(Port.DataFrame("in"))
  val outputPorts = List(Port.DataFrameList("out"))

  val transposedColumnsParameter = Parameter.StringList("transposed-columns", required = true)
  val pivotColumnParameter = Parameter.String("pivot-column", required = true)

  val parameterGroups = List(ParameterGroup("general", List(transposedColumnsParameter, pivotColumnParameter)), logGroup)

}