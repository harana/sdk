package com.harana.sdk.shared.models.flow.actiontypes.input.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.ConnectionTypes
import com.harana.sdk.shared.models.flow.actiontypes.input.InputActionTypeInfo

class GetCouchbaseInfo extends InputActionTypeInfo {

  val id = "A602FEAC-1655-48A4-B69C-D3F092DB08C9"

  val tags = Set()
  val dataSourceType = ConnectionTypes.Couchbase
  val dataSourceParameter = Parameter.Connection("data-source", dataSourceType, required = true)
  val parameterGroups = List(ParameterGroup("general", List(dataSourceParameter)))

}