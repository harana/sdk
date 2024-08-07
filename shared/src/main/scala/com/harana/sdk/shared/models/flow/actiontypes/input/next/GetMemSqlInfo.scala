package com.harana.sdk.shared.models.flow.actiontypes.input.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.ConnectionTypes
import com.harana.sdk.shared.models.flow.actiontypes.input.InputActionTypeInfo

class GetMemSqlInfo extends InputActionTypeInfo {

  val id = "08CE49C0-5B5C-4B5B-8526-FFF2BC74E515"

  val tags = Set()
  val dataSourceType = ConnectionTypes.MemSql
  val dataSourceParameter = Parameter.Connection("data-source", dataSourceType, required = true)
  val databaseParameter = Parameter.String("database", required = true)
  val tableParameter = Parameter.String("table", required = true)
  val parameterGroups = List(ParameterGroup("general", List(dataSourceParameter, databaseParameter, tableParameter)))

}