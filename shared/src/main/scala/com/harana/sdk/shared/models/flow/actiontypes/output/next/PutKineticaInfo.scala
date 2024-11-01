package com.harana.sdk.shared.models.flow.actiontypes.output.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.ConnectionTypes
import com.harana.sdk.shared.models.flow.actiontypes.output.OutputActionTypeInfo

class PutKineticaInfo extends OutputActionTypeInfo {

  val id = "D83B82F1-9C90-4BF1-9815-CFE1B0B6BD4C"

  val tags = Set()
  val dataSourceType = ConnectionTypes.Kinetica

  // General
  val dataSourceParameter = Parameter.Connection("data-source", dataSourceType, required = true)
  val schemaParameter = Parameter.String("schema", required = true)
  val tableParameter = Parameter.String("table", required = true)
  val generalGroup = ParameterGroup("general", List(dataSourceParameter, schemaParameter, tableParameter))

  // Advanced
  val targetTableIsReplicatedParameter = Parameter.Boolean("targetTableIsReplicated", default = Some(false))
  val truncateTableParameter = Parameter.Boolean("truncateTable", default = Some(false))
  val truncateTableToSizeParameter = Parameter.Boolean("truncateTableToSize", default = Some(false))
  val updateOnExistingPrimaryKeyParameter = Parameter.Boolean("updateOnExistingPrimaryKey", default = Some(false))
  val analyzeDataParameter = Parameter.Boolean("analyzeData", default = Some(false))
  val failOnErrorsParameter = Parameter.Boolean("failOnErrors", default = Some(false))
  val flattenSourceSchemaParameter = Parameter.Boolean("flattenSourceSchema", default = Some(false))
  val useSnappyCompressionParameter = Parameter.Boolean("useSnappyCompression", default = Some(false))
  val timeZoneParameter = Parameter.String("timeZone")
  val appendNewColumnsParameter = Parameter.Boolean("appendNewColumns", default = Some(false))
  val mapColumnsByNameParameter = Parameter.Boolean("mapColumnsByName", default = Some(false))
  val advancedGroup = ParameterGroup("advanced", List(targetTableIsReplicatedParameter, truncateTableParameter, truncateTableToSizeParameter, analyzeDataParameter,
    failOnErrorsParameter, flattenSourceSchemaParameter, useSnappyCompressionParameter, timeZoneParameter, appendNewColumnsParameter, mapColumnsByNameParameter))

  val parameterGroups = List(generalGroup, advancedGroup)

}