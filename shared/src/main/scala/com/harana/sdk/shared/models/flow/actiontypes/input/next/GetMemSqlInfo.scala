package com.harana.sdk.shared.models.flow.actiontypes.input.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.ConnectionTypes
import com.harana.sdk.shared.models.flow.actiontypes.input.InputActionTypeInfo

class GetMemSqlInfo extends InputActionTypeInfo {

  val tags = Set()
  val dataSourceType = ConnectionTypes.MemSql
  val dataSourceParameter = Parameter.Connection("data-source", dataSourceType, required = true)
  val databaseParameter = Parameter.String("database", required = true)
  val tableParameter = Parameter.String("table", required = true)
  val parameterGroups = List(ParameterGroup("general", List(dataSourceParameter, databaseParameter, tableParameter)))

}