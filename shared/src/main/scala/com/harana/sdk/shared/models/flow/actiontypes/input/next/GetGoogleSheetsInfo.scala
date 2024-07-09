package com.harana.sdk.shared.models.flow.actiontypes.input.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.ConnectionTypes
import com.harana.sdk.shared.models.flow.actiontypes.input.InputActionTypeInfo

class GetGoogleSheetsInfo extends InputActionTypeInfo {

  val id = "39A25BFF-1A60-4B7E-A0A4-DE83FA3FC0ED"

  val tags = Set()
  val dataSourceType = ConnectionTypes.GoogleSheets
  val dataSourceParameter = Parameter.Connection("data-source", dataSourceType, required = true)
  val parameterGroups = List(ParameterGroup("general", List(dataSourceParameter)))

}