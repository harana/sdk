package com.harana.sdk.shared.models.flow.actiontypes.output.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.ConnectionTypes
import com.harana.sdk.shared.models.flow.actiontypes.output.OutputActionTypeInfo

class PutAzureSqlDbInfo extends OutputActionTypeInfo {

  val id = "6458245E-54CE-4D02-9B66-92B4DF476283"

  val tags = Set()
  val dataSourceType = ConnectionTypes.AzureSqlDb
  val dataSourceParameter = Parameter.Connection("data-source", dataSourceType, required = true)
  val parameterGroups = List(ParameterGroup("general", List(dataSourceParameter)))

}