package com.harana.sdk.shared.models.flow.actiontypes.input.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.ConnectionTypes
import com.harana.sdk.shared.models.flow.actiontypes.input.InputActionTypeInfo

class GetInfluxInfo extends InputActionTypeInfo {

  val id = "BDF4CFCB-01D6-4D3A-A055-87B20866C30E"

  val tags = Set()
  val dataSourceType = ConnectionTypes.Influx
  val dataSourceParameter = Parameter.Connection("data-source", dataSourceType, required = true)
  val parameterGroups = List(ParameterGroup("general", List(dataSourceParameter)))

}