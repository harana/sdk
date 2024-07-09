package com.harana.sdk.shared.models.flow.actiontypes.input.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup, ParameterValue}
import com.harana.sdk.shared.models.data.ConnectionTypes
import com.harana.sdk.shared.models.flow.actiontypes.input.InputActionTypeInfo

class GetRedisInfo extends InputActionTypeInfo {

  val id = "D34B7039-3EEF-425C-BCFB-86021FCC0A8D"

  val tags = Set()

  // General
  val dataSourceType = ConnectionTypes.Redis
  val dataSourceParameter = Parameter.Connection("data-source", dataSourceType, required = true)
  val tableParameter = Parameter.String("table", required = true)
  val generalGroup = ParameterGroup("general", List(dataSourceParameter, tableParameter))

  // Advanced
  val filterKeysByTypeParameter = Parameter.Boolean("filterKeysByType")
  val keyColumnParameter = Parameter.String("keyColumn")
  val keysPatternParameter = Parameter.String("keysPattern")
  val partitionsParameter = Parameter.Long("partitions", default = Some(ParameterValue.Long(3)))
  val inferSchemaParameter = Parameter.Boolean("inferSchema")
  val maxPipelineSizeParameter = Parameter.Long("maxPipelineSize", default = Some(ParameterValue.Long(100)))
  val scanCountParameter = Parameter.Long("scanCount", default = Some(ParameterValue.Long(0)))
  val iteratorGroupingSizeParameter = Parameter.Long("iteratorGroupingSize", default = Some(ParameterValue.Long(1000)))
  val advancedGroup = ParameterGroup("advanced", List(filterKeysByTypeParameter, keyColumnParameter, keysPatternParameter, partitionsParameter, inferSchemaParameter, maxPipelineSizeParameter, scanCountParameter, iteratorGroupingSizeParameter))

  val parameterGroups = List(generalGroup, advancedGroup)

}