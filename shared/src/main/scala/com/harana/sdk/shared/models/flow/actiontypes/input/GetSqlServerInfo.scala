package com.harana.sdk.shared.models.flow.actiontypes.input

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.ConnectionTypes
import com.harana.sdk.shared.models.flow.actiontypes.logGroup

class GetSqlServerInfo extends JdbcInputActionTypeInfo {

  val id = "5596ACC1-A485-403A-985E-ED853485F4EE"

  val tags = Set()
  val dataSourceType = ConnectionTypes.SqlServer
  val dataSourceParameter = Parameter.Connection("data-source", dataSourceType, required = true)
  val parameterGroups = List(ParameterGroup("general", List(dataSourceParameter)), logGroup)

}