package com.harana.sdk.shared.models.flow.actiontypes.input.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup, ParameterValue}
import com.harana.sdk.shared.models.data.DataSourceTypes
import com.harana.sdk.shared.models.flow.actiontypes.input.InputActionTypeInfo

class GetZuoraInfo extends InputActionTypeInfo {

  val tags = Set()

  // General
  val dataSourceType = DataSourceTypes.Zuora
  val dataSourceParameter = Parameter.DataSource("data-source", dataSourceType, required = true)
  val queryParameter = Parameter.String("query", multiLine = true, required = true)
  val generalGroup = ParameterGroup("general", List(dataSourceParameter, queryParameter))

  // Advanced
  val pageSizeParameter = Parameter.Long("pageSize", default = Some(ParameterValue.Long(1000)))
  val schemaParameter = Parameter.String("schema")
  val advancedGroup = ParameterGroup("advanced", List(pageSizeParameter, schemaParameter))

  val parameterGroups = List(generalGroup, advancedGroup)

}