package com.harana.sdk.shared.models.flow.actiontypes.input.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.ConnectionTypes
import com.harana.sdk.shared.models.flow.actiontypes.input.InputActionTypeInfo

class GetAzureKustoInfo extends InputActionTypeInfo {

  val id = "EC52CFC9-ADFE-4ED3-8E8A-9CDFBB7BAC05"

  val tags = Set("azure")
  val parameterTypes = List()

  val dataSourceType = ConnectionTypes.AzureKusto

  // General
  val dataSourceParameter = Parameter.Connection("data-source", dataSourceType, required = true)
  val databaseParameter = Parameter.String("database", required = true)
  val tableParameter = Parameter.String("table")
  val queryParameter = Parameter.String("query", multiLine = true)
  val generalGroup = ParameterGroup("general", List(dataSourceParameter, databaseParameter, tableParameter, queryParameter))

  val parameterGroups = List(generalGroup)
}