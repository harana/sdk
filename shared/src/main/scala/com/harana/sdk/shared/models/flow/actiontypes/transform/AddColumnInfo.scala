package com.harana.sdk.shared.models.flow.actiontypes.transform

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup, ParameterValue}
import com.harana.sdk.shared.models.flow.actiontypes.{ActionTypeGroup, logGroup}
import com.harana.sdk.shared.models.flow.{ActionTypeInfo, Port}

class AddColumnInfo extends ActionTypeInfo {

  val id = "92F5F68A-5A1A-4545-A258-E2AE5D01BBAF"

  val tags = Set()
  val group = ActionTypeGroup.Transform
  val inputPorts = List(Port.DataFrame("in"))
  val outputPorts = List(Port.DataFrame("out"))

  val typeParameter = Parameter.String("type", required = true, options = List(
    ("value", ParameterValue.String("value")),
    ("uuid", ParameterValue.String("uuid")),
    ("empty", ParameterValue.String("empty"))
  ))
  val nameParameter = Parameter.String("name", required = true)
  val valueTypeParameter = Parameter.String("valueType", required = true, options = List(
    ("integer", ParameterValue.String("integer")),
    ("double", ParameterValue.String("double")),
    ("string", ParameterValue.String("string"))
  ))
  val valueParameter = Parameter.String("value", required = true)
  val parameterGroups = List(ParameterGroup("general", List(typeParameter, nameParameter, valueParameter)), logGroup)

}