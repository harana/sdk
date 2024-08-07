package com.harana.sdk.shared.models.flow.actiontypes.output.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup, ParameterValue}
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
  val targetTableIsReplicatedParameter = Parameter.Boolean("targetTableIsReplicated", default = Some(ParameterValue.Boolean(false)))
  val truncateTableParameter = Parameter.Boolean("truncateTable", default = Some(ParameterValue.Boolean(false)))
  val truncateTableToSizeParameter = Parameter.Boolean("truncateTableToSize", default = Some(ParameterValue.Boolean(false)))
  val updateOnExistingPrimaryKeyParameter = Parameter.Boolean("updateOnExistingPrimaryKey", default = Some(ParameterValue.Boolean(false)))
  val analyzeDataParameter = Parameter.Boolean("analyzeData", default = Some(ParameterValue.Boolean(false)))
  val failOnErrorsParameter = Parameter.Boolean("failOnErrors", default = Some(ParameterValue.Boolean(false)))
  val flattenSourceSchemaParameter = Parameter.Boolean("flattenSourceSchema", default = Some(ParameterValue.Boolean(false)))
  val useSnappyCompressionParameter = Parameter.Boolean("useSnappyCompression", default = Some(ParameterValue.Boolean(false)))
  val timeZoneParameter = Parameter.String("timeZone")
  val appendNewColumnsParameter = Parameter.Boolean("appendNewColumns", default = Some(ParameterValue.Boolean(false)))
  val mapColumnsByNameParameter = Parameter.Boolean("mapColumnsByName", default = Some(ParameterValue.Boolean(false)))
  val advancedGroup = ParameterGroup("advanced", List(targetTableIsReplicatedParameter, truncateTableParameter, truncateTableToSizeParameter, analyzeDataParameter,
    failOnErrorsParameter, flattenSourceSchemaParameter, useSnappyCompressionParameter, timeZoneParameter, appendNewColumnsParameter, mapColumnsByNameParameter))

  val parameterGroups = List(generalGroup, advancedGroup)

}