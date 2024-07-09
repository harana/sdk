package com.harana.sdk.shared.models.flow.actiontypes.output

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.ConnectionTypes
import com.harana.sdk.shared.models.flow.actiontypes.logGroup

class PutSqlServerInfo extends JdbcOutputActionTypeInfo {

  val id = "1E39356B-ADB8-4C47-B5F5-D1E153934F5B"

  val tags = Set()
  val dataSourceType = ConnectionTypes.SqlServer
  val dataSourceParameter = Parameter.Connection("data-source", dataSourceType, required = true)
  val generalGroup = ParameterGroup("general", List(dataSourceParameter) ++ jdbcGeneralParameters)
  val parameterGroups = List(generalGroup, jdbcAdvancedGroup, logGroup)

}