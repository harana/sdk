package com.harana.sdk.shared.models.flow.actiontypes.transform

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup, ParameterValue}
import com.harana.sdk.shared.models.flow.actiontypes.{ActionTypeGroup, logGroup}
import com.harana.sdk.shared.models.flow.{ActionTypeInfo, Port}

class JoinInfo extends ActionTypeInfo {

  val tags = Set()
  val group = ActionTypeGroup.Transform
  val inputPorts = List(Port.DataFrame("left-in"), Port.DataFrame("right-in"))
  val outputPorts = List(Port.DataFrame("out"))

  val modeParameter = Parameter.String("mode", Some(ParameterValue.String("left")), required = true, options = List(
    ("inner", ParameterValue.String("inner")),
    ("left", ParameterValue.String("left")),
    ("right", ParameterValue.String("right")),
    ("outer", ParameterValue.String("outer"))
  ))
  val columnsParameter = Parameter.StringList("columns", required = true)
  val parameterGroups = List(ParameterGroup("general", List(modeParameter, columnsParameter)), logGroup)

}