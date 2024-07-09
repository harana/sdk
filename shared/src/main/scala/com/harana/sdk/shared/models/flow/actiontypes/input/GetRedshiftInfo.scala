package com.harana.sdk.shared.models.flow.actiontypes.input

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.ConnectionTypes
import com.harana.sdk.shared.models.flow.actiontypes.logGroup

class GetRedshiftInfo extends JdbcInputActionTypeInfo {

  val id = "215283DC-CFA2-4E15-AE22-231E61D2F792"

  val tags = Set()
  val dataSourceType = ConnectionTypes.Redshift

  val dataSourceParameter = Parameter.Connection("data-source", dataSourceType, required = true)
  val generalGroup = ParameterGroup("general", List(dataSourceParameter) ++ jdbcGeneralParameters)
  val parameterGroups = List(generalGroup, jdbcAdvancedGroup, logGroup)

}