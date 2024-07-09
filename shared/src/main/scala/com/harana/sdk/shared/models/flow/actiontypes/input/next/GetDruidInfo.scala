package com.harana.sdk.shared.models.flow.actiontypes.input.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.ConnectionTypes
import com.harana.sdk.shared.models.flow.actiontypes.input.InputActionTypeInfo

class GetDruidInfo extends InputActionTypeInfo {

  val id = "72F6927B-A759-41D4-B3DB-78E015DBF663"

  val tags = Set()
  val dataSourceType = ConnectionTypes.Druid
  val dataSourceParameter = Parameter.Connection("data-source", dataSourceType, required = true)
  val parameterGroups = List(ParameterGroup("general", List(dataSourceParameter)))

}