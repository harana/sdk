package com.harana.sdk.shared.models.flow.actiontypes.input.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup, ParameterValue}
import com.harana.sdk.shared.models.data.ConnectionTypes
import com.harana.sdk.shared.models.flow.actiontypes.input.InputActionTypeInfo

class GetSalesforceInfo extends InputActionTypeInfo {

  val id = "08C581AA-1C1A-44C8-A560-9B7E3B0DB514"

  val tags = Set()

  // General
  val dataSourceType = ConnectionTypes.Salesforce
  val dataSourceParameter = Parameter.Connection("data-source", dataSourceType, required = true)
  val queryParameter = Parameter.String("query", multiLine = true, required = true)
  val generalGroup = ParameterGroup("general", List(dataSourceParameter, queryParameter))

  // Bulk
  val bulkParameter = Parameter.Boolean("bulk")
  val primaryKeyChunkingParameter = Parameter.Boolean("primaryKeyChunking")
  val chunkSizeParameter = Parameter.Long("chunkSize", default = Some(ParameterValue.Long(100000)))
  val timeoutParameter = Parameter.Long("timeout")
  val bulkGroup = ParameterGroup("bulk", List(bulkParameter, primaryKeyChunkingParameter, chunkSizeParameter, timeoutParameter))

  // Advanced
  val inferSchemaParameter = Parameter.Boolean("inferSchema")
  val pageSizeParameter = Parameter.Long("pageSize", default = Some(ParameterValue.Long(2000)))
  val metadataConfigParameter = Parameter.Json("metadataConfig")
  val resultVariableParameter = Parameter.String("resultVariable")
  val externalIdFieldNameParameter = Parameter.String("externalIdFieldName", default = Some(ParameterValue.String("Id")))
  val queryAllParameter = Parameter.Boolean("queryAll")
  val versionParameter = Parameter.Decimal("version", default = Some(ParameterValue.Decimal(35.0)))
  val advancedGroup = ParameterGroup("advanced", List(externalIdFieldNameParameter, queryAllParameter))

  val parameterGroups = List(generalGroup, bulkGroup, advancedGroup)

}