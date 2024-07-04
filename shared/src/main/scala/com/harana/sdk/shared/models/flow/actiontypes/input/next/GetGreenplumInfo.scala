package com.harana.sdk.shared.models.flow.actiontypes.input.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.ConnectionTypes
import com.harana.sdk.shared.models.flow.actiontypes.input.InputActionTypeInfo

class GetGreenplumInfo extends InputActionTypeInfo {

  val tags = Set()
  val dataSourceType = ConnectionTypes.Greenplum

  // General
  val dataSourceParameter = Parameter.Connection("data-source", dataSourceType, required = true)
  val generalGroup = ParameterGroup("general", List(dataSourceParameter))

  // Advanced
  val partitionColumnParameter = Parameter.String("partition-column")
  val partitionsParameter = Parameter.Long("partitions")

  val parameterGroups = List(ParameterGroup("general", List(dataSourceParameter)))

}