package com.harana.sdk.shared.models.flow.actiontypes.input

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.ConnectionTypes
import com.harana.sdk.shared.models.flow.actiontypes.logGroup

class GetMySqlInfo extends JdbcInputActionTypeInfo {

  val id = "43D0543E-146C-4FF5-A3CC-55F79A4E2CBA"

  val tags = Set()
  val dataSourceType = ConnectionTypes.MySql

  val dataSourceParameter = Parameter.Connection("data-source", dataSourceType, required = true)
  val generalGroup = ParameterGroup("general", List(dataSourceParameter) ++ jdbcGeneralParameters)
  val parameterGroups = List(generalGroup, jdbcAdvancedGroup, logGroup)

}