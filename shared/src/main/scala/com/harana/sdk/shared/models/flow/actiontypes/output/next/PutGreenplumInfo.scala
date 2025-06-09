package com.harana.sdk.shared.models.flow.actiontypes.output.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.ConnectionTypes
import com.harana.sdk.shared.models.flow.actiontypes.output.OutputActionTypeInfo
import com.harana.sdk.shared.models.common.ParameterValue.given

class PutGreenplumInfo extends OutputActionTypeInfo {

  val id = "16F91D2A-50A9-45B2-A13E-218ABABA95AA"

  val tags = Set()

  // General
  val dataSourceType = ConnectionTypes.Greenplum
  val dataSourceParameter = Parameter.Connection("data-source", dataSourceType, required = true)
  val generalGroup = ParameterGroup("general", List(dataSourceParameter))

  // Advanced
  val truncateParameter = Parameter.Boolean("truncate")
  val distributedByParameter = Parameter.StringList("distributedBy")
  val iteratorOptimizationParameter = Parameter.Boolean("iteratorOptimization", default = true)

  val advancedGroup = ParameterGroup("advanced", List(truncateParameter))

  val parameterGroups = List(generalGroup, advancedGroup)
}
