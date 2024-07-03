package com.harana.sdk.shared.models.flow.actiontypes.transform

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.flow.actiontypes.{ActionTypeGroup, logGroup}
import com.harana.sdk.shared.models.flow.{ActionTypeInfo, Port}

class RenameColumnInfo extends ActionTypeInfo {

  val tags = Set()
  val group = ActionTypeGroup.Transform
  val inputPorts = List(Port.DataFrame("in"))
  val outputPorts = List(Port.DataFrame("out"))

  val existingNameParameter = Parameter.String("existing-name", required = true)
  val newNameParameter = Parameter.String("new-name", required = true)
  val parameterGroups = List(ParameterGroup("general", List(existingNameParameter, newNameParameter)), logGroup)

}