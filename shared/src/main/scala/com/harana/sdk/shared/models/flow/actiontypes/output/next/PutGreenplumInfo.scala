package com.harana.sdk.shared.models.flow.actiontypes.output.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup, ParameterValue}
import com.harana.sdk.shared.models.data.DataSourceTypes
import com.harana.sdk.shared.models.flow.actiontypes.output.OutputActionTypeInfo

class PutGreenplumInfo extends OutputActionTypeInfo {

  val tags = Set()

  // General
  val dataSourceType = DataSourceTypes.Greenplum
  val dataSourceParameter = Parameter.DataSource("data-source", dataSourceType, required = true)
  val generalGroup = ParameterGroup("general", List(dataSourceParameter))

  // Advanced
  val truncateParameter = Parameter.Boolean("truncate", default = Some(ParameterValue.Boolean(false)))
  val distributedByParameter = Parameter.StringList("distributedBy")
  val iteratorOptimizationParameter = Parameter.Boolean("iteratorOptimization", default = Some(ParameterValue.Boolean(true)))

  val advancedGroup = ParameterGroup("advanced", List(truncateParameter))

  val parameterGroups = List(generalGroup, advancedGroup)
}
