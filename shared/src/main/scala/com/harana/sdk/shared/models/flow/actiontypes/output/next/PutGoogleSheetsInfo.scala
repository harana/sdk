package com.harana.sdk.shared.models.flow.actiontypes.output.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.flow.actiontypes.ActionTypeGroup
import com.harana.sdk.shared.models.data.ConnectionTypes
import com.harana.sdk.shared.models.flow.actiontypes.output.OutputActionTypeInfo

class PutGoogleSheetsInfo extends OutputActionTypeInfo {

  val id = "BCB51550-2D95-43F1-A5E9-790EB959D66A"

  val tags = Set()
  val dataSourceType = ConnectionTypes.GoogleSheets
  val dataSourceParameter = Parameter.Connection("data-source", dataSourceType, required = true)
  val parameterGroups = List(ParameterGroup("general", List(dataSourceParameter)))

}