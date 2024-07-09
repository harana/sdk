package com.harana.sdk.shared.models.flow.actiontypes.input.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.ConnectionTypes
import com.harana.sdk.shared.models.flow.actiontypes.input.JdbcInputActionTypeInfo

class GetOrientDbInfo extends JdbcInputActionTypeInfo {

  val id = "B06FCC43-E988-4037-BA5C-473507B4411A"

  val tags = Set()
  val dataSourceType = ConnectionTypes.OrientDb

  val dataSourceParameter = Parameter.Connection("data-source", dataSourceType, required = true)
  val generalGroup = ParameterGroup("general", List(dataSourceParameter) ++ jdbcGeneralParameters)
  val parameterGroups = List(generalGroup, jdbcAdvancedGroup)

}