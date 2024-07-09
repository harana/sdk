package com.harana.sdk.shared.models.flow.actiontypes.transform

import com.harana.sdk.shared.models.flow.actiontypes.{ActionTypeGroup, logGroup}
import com.harana.sdk.shared.models.flow.{ActionTypeInfo, Port}

class MergeInfo extends ActionTypeInfo {

  val id = "30731E94-4DB0-4016-95EF-77E95F77DCC0"

  val tags = Set()
  val group = ActionTypeGroup.Transform
  val inputPorts = List(Port.DataFrameList("in"))
  val outputPorts = List(Port.DataFrame("out"))
  val parameterGroups = List(logGroup)

}