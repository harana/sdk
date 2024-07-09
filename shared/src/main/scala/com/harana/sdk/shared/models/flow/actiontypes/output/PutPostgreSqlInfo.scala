package com.harana.sdk.shared.models.flow.actiontypes.output

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.flow.actiontypes.{ActionTypeGroup, logGroup}
import com.harana.sdk.shared.models.data.ConnectionTypes

class PutPostgreSqlInfo extends JdbcOutputActionTypeInfo {

  val id = "317565A4-AE36-415A-B167-19D141D488D6"

  val tags = Set()
  val dataSourceType = ConnectionTypes.PostgreSql
  val dataSourceParameter = Parameter.Connection("data-source", dataSourceType, required = true)
  val generalGroup = ParameterGroup("general", List(dataSourceParameter) ++ jdbcGeneralParameters)
  val parameterGroups = List(generalGroup, jdbcAdvancedGroup, logGroup)

}