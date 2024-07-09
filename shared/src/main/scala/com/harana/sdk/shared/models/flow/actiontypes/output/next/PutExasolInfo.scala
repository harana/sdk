package com.harana.sdk.shared.models.flow.actiontypes.output.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup, ParameterValue}
import com.harana.sdk.shared.models.data.ConnectionTypes
import com.harana.sdk.shared.models.flow.actiontypes.output.OutputActionTypeInfo

class PutExasolInfo extends OutputActionTypeInfo {

  val id = "80DDC371-7D57-4C39-A51A-70C46FE8A697"

  val tags = Set()

  // General
  val dataSourceType = ConnectionTypes.Exasol
  val dataSourceParameter = Parameter.Connection("data-source", dataSourceType, required = true)
  val tableParameter = Parameter.String("table", required = true)

  val generalGroup = ParameterGroup("general", List(dataSourceParameter, tableParameter))

  // Advanced
  val batchSizeParameter = Parameter.Long("batchSize", default = Some(ParameterValue.Long(1000)))
  val createTableParameter = Parameter.Boolean("createTable")
  val dropTableParameter = Parameter.Boolean("dropTable")

  val advancedGroup = ParameterGroup("advanced", List(batchSizeParameter, createTableParameter, dropTableParameter))

  val parameterGroups = List(generalGroup, advancedGroup)
}
