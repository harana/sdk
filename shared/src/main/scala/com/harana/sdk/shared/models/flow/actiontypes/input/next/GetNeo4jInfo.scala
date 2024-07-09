package com.harana.sdk.shared.models.flow.actiontypes.input.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.ConnectionTypes
import com.harana.sdk.shared.models.flow.actiontypes.input.InputActionTypeInfo

class GetNeo4jInfo extends InputActionTypeInfo {

  val id = "89FC9959-9890-4AF3-A25D-25D99732CE3A"

  val tags = Set()
  val dataSourceType = ConnectionTypes.Neo4j
  val dataSourceParameter = Parameter.Connection("data-source", dataSourceType, required = true)
  val parameterGroups = List(ParameterGroup("general", List(dataSourceParameter)))

}