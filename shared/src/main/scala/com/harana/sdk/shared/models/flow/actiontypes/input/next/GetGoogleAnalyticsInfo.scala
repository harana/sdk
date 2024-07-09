package com.harana.sdk.shared.models.flow.actiontypes.input.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.ConnectionTypes
import com.harana.sdk.shared.models.flow.actiontypes.input.InputActionTypeInfo

class GetGoogleAnalyticsInfo extends InputActionTypeInfo {

  val id = "4C6EA8AA-EF15-4558-927D-00AA80B6BC61"

  val tags = Set()
  val dataSourceType = ConnectionTypes.GoogleAnalytics
  val dataSourceParameter = Parameter.Connection("data-source", dataSourceType, required = true)
  val parameterGroups = List(ParameterGroup("general", List(dataSourceParameter)))

}