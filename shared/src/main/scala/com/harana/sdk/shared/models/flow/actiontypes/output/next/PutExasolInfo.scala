package com.harana.sdk.shared.models.flow.actiontypes.output.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup, ParameterValue}
import com.harana.sdk.shared.models.data.DataSourceTypes
import com.harana.sdk.shared.models.flow.actiontypes.output.OutputActionTypeInfo

class PutExasolInfo extends OutputActionTypeInfo {

  val tags = Set()

  // General
  val dataSourceType = DataSourceTypes.Exasol
  val dataSourceParameter = Parameter.DataSource("data-source", dataSourceType, required = true)
  val tableParameter = Parameter.String("table", required = true)

  val generalGroup = ParameterGroup("general", List(dataSourceParameter, tableParameter))

  // Advanced
  val batchSizeParameter = Parameter.Long("batchSize", default = Some(ParameterValue.Long(1000)))
  val createTableParameter = Parameter.Boolean("createTable")
  val dropTableParameter = Parameter.Boolean("dropTable")

  val advancedGroup = ParameterGroup("advanced", List(batchSizeParameter, createTableParameter, dropTableParameter))

  val parameterGroups = List(generalGroup, advancedGroup)
}
