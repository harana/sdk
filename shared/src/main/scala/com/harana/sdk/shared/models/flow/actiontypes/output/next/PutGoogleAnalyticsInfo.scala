package com.harana.sdk.shared.models.flow.actiontypes.output.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.flow.actiontypes.ActionTypeGroup
import com.harana.sdk.shared.models.data.ConnectionTypes
import com.harana.sdk.shared.models.flow.actiontypes.output.OutputActionTypeInfo

class PutGoogleAnalyticsInfo extends OutputActionTypeInfo {

  val id = "0A643F6D-FEF9-4A46-80F1-5B3F7967ABB2"

  val tags = Set()
  val dataSourceType = ConnectionTypes.GoogleAnalytics
  val dataSourceParameter = Parameter.Connection("data-source", dataSourceType, required = true)
  val parameterGroups = List(ParameterGroup("general", List(dataSourceParameter)))

}