package com.harana.sdk.shared.models.flow.actiontypes.input.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.ConnectionTypes
import com.harana.sdk.shared.models.flow.actiontypes.input.InputActionTypeInfo

class GetClickhouseInfo extends InputActionTypeInfo {

  val id = "55FE6230-E05E-47DB-B8FF-F4FAA399D7A9"

  val tags = Set()
  val dataSourceType = ConnectionTypes.Clickhouse
  val dataSourceParameter = Parameter.Connection("data-source", dataSourceType, required = true)
  val parameterGroups = List(ParameterGroup("general", List(dataSourceParameter)))

}