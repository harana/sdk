package com.harana.sdk.shared.models.flow.actiontypes.transform

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.flow.actiontypes.{ActionTypeGroup, logGroup}
import com.harana.sdk.shared.models.flow.{ActionTypeInfo, Port}

class RenameColumnInfo extends ActionTypeInfo {

  val id = "44E97852-97B0-4D87-8320-9F56BF686BE9"

  val tags = Set()
  val group = ActionTypeGroup.Transform
  val inputPorts = List(Port.DataFrame("in"))
  val outputPorts = List(Port.DataFrame("out"))

  val existingNameParameter = Parameter.String("existing-name", required = true)
  val newNameParameter = Parameter.String("new-name", required = true)
  val parameterGroups = List(ParameterGroup("general", List(existingNameParameter, newNameParameter)), logGroup)

}