package com.harana.sdk.shared.models.flow.actiontypes.output.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.flow.actiontypes.ActionTypeGroup
import com.harana.sdk.shared.models.data.ConnectionTypes
import com.harana.sdk.shared.models.flow.actiontypes.output.OutputActionTypeInfo

class PutCouchbaseInfo extends OutputActionTypeInfo {

  val id = "9C1578A7-7752-4E29-9138-095899C954FE"

  val tags = Set()
  val dataSourceType = ConnectionTypes.Couchbase
  val dataSourceParameter = Parameter.Connection("data-source", dataSourceType, required = true)
  val parameterGroups = List(ParameterGroup("general", List(dataSourceParameter)))

}