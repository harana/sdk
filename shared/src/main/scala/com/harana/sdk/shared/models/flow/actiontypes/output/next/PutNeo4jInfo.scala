package com.harana.sdk.shared.models.flow.actiontypes.output.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.flow.actiontypes.ActionTypeGroup
import com.harana.sdk.shared.models.data.ConnectionTypes
import com.harana.sdk.shared.models.flow.actiontypes.output.OutputActionTypeInfo

class PutNeo4jInfo extends OutputActionTypeInfo {

  val id = "43753A8B-64FC-4A35-8BAE-2E6362B9BFE7"

  val tags = Set()
  val dataSourceType = ConnectionTypes.Neo4j
  val dataSourceParameter = Parameter.Connection("data-source", dataSourceType, required = true)
  val parameterGroups = List(ParameterGroup("general", List(dataSourceParameter)))

}