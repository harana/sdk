package com.harana.sdk.shared.models.flow.actiontypes.input.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.DataSourceTypes
import com.harana.sdk.shared.models.flow.actiontypes.input.InputActionTypeInfo

class GetExasolInfo extends InputActionTypeInfo {

  val tags = Set()

  // General
  val dataSourceType = DataSourceTypes.Exasol
  val dataSourceParameter = Parameter.DataSource("data-source", dataSourceType, required = true)

  val parameterGroups = List()
}