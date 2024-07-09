package com.harana.sdk.shared.models.flow.actiontypes.output.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup, ParameterValue}
import com.harana.sdk.shared.models.data.ConnectionTypes
import com.harana.sdk.shared.models.flow.actiontypes.output.OutputActionTypeInfo

class PutRedisInfo extends OutputActionTypeInfo {

  val id = "56CE7D7A-F4B6-4CEC-B508-AFB23FBB28AA"

  val tags = Set()

  // General
  val dataSourceType = ConnectionTypes.Redis
  val dataSourceParameter = Parameter.Connection("data-source", dataSourceType, required = true)
  val tableParameter = Parameter.String("table", required = true)
  val generalGroup = ParameterGroup("general", List(dataSourceParameter, tableParameter))

  // Advanced
  val modelParameter = Parameter.String("model", options = List(
    ("binary", ParameterValue.String("binary")),
    ("enum", ParameterValue.String("enum")),
    ("hash", ParameterValue.String("hash"))
  ))
  val filterKeysByTypeParameter = Parameter.Boolean("filterKeysByType")
  val keyColumnParameter = Parameter.String("keyColumn")
  val ttlParameter = Parameter.Long("ttl", default = Some(ParameterValue.Long(0)))
  val maxPipelineSizeParameter = Parameter.Long("maxPipelineSize", default = Some(ParameterValue.Long(100)))
  val advancedGroup = ParameterGroup("advanced", List(modelParameter, filterKeysByTypeParameter, keyColumnParameter, ttlParameter, maxPipelineSizeParameter))

  val parameterGroups = List(generalGroup, advancedGroup)

}
