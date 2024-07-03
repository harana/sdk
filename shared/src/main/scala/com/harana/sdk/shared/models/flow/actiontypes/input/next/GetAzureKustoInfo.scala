package com.harana.sdk.shared.models.flow.actiontypes.input.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.DataSourceTypes
import com.harana.sdk.shared.models.flow.actiontypes.input.InputActionTypeInfo

class GetAzureKustoInfo extends InputActionTypeInfo {

  val tags = Set("azure")
  val parameterTypes = List()

  val dataSourceType = DataSourceTypes.AzureKusto

  // General
  val dataSourceParameter = Parameter.DataSource("data-source", dataSourceType, required = true)
  val databaseParameter = Parameter.String("database", required = true)
  val tableParameter = Parameter.String("table")
  val queryParameter = Parameter.String("query", multiLine = true)
  val generalGroup = ParameterGroup("general", List(dataSourceParameter, databaseParameter, tableParameter, queryParameter))

  val parameterGroups = List(generalGroup)
}