package com.harana.sdk.shared.models.flow.actiontypes.input.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.ConnectionTypes
import com.harana.sdk.shared.models.flow.actiontypes.input.InputActionTypeInfo

class GetGoogleSpannerInfo extends InputActionTypeInfo {

  val id = "DCB97CA7-EF9E-478B-8449-CE8AD98C3FE7"

  val tags = Set()
  val dataSourceType = ConnectionTypes.GoogleSpanner
  val dataSourceParameter = Parameter.Connection("data-source", dataSourceType, required = true)
  val parameterGroups = List(ParameterGroup("general", List(dataSourceParameter)))

}