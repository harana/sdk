package com.harana.sdk.shared.models.flow.actiontypes.input.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.ConnectionTypes
import com.harana.sdk.shared.models.flow.actiontypes.input.InputActionTypeInfo

class GetExasolInfo extends InputActionTypeInfo {

  val id = "A36057D2-2A40-44C0-B31D-05E7C3BCC6F4"

  val tags = Set()

  // General
  val dataSourceType = ConnectionTypes.Exasol
  val dataSourceParameter = Parameter.Connection("data-source", dataSourceType, required = true)

  val parameterGroups = List()
}