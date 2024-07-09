package com.harana.sdk.shared.models.flow.actiontypes.output

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.flow.actiontypes.{ActionTypeGroup, logGroup}
import com.harana.sdk.shared.models.data.ConnectionTypes

class PutRedshiftInfo extends JdbcOutputActionTypeInfo {

  val id = "8C877A90-493D-4761-83D1-4AF78278C7E4"

  val tags = Set()
  val dataSourceType = ConnectionTypes.Redshift
  val dataSourceParameter = Parameter.Connection("data-source", dataSourceType, required = true)
  val generalGroup = ParameterGroup("general", List(dataSourceParameter) ++ jdbcGeneralParameters)
  val parameterGroups = List(generalGroup, jdbcAdvancedGroup, logGroup)

}