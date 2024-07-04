package com.harana.sdk.shared.models.flow.actiontypes.output.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.flow.actiontypes.ActionTypeGroup
import com.harana.sdk.shared.models.data.ConnectionTypes
import com.harana.sdk.shared.models.data.ConnectionTypes.Cloudant
import com.harana.sdk.shared.models.flow.actiontypes.output.OutputActionTypeInfo

class PutCloudantInfo extends OutputActionTypeInfo {

  val tags = Set()
  val dataSourceType = ConnectionTypes.Cloudant

  // General
  val dataSourceParameter = Parameter.Connection("data-source", dataSourceType, required = true)
  val databaseParameter = Parameter.String("database", required = true)
  val indexParameter = Parameter.String("index", required = true)
  val viewParameter = Parameter.String("view")

  val generalGroup = ParameterGroup("general", List(
    dataSourceParameter, databaseParameter, indexParameter, viewParameter
  ))

  // Advanced
  val bulkSizeParameter = Cloudant.bulkSizeParameter
  val schemaSampleSizeParameter = Cloudant.schemaSampleSizeParameter
  val selectorParameter = Cloudant.selectorParameter
  val createDatabaseOnSaveParameter = Cloudant.createDatabaseOnSaveParameter

  val advancedGroup = ParameterGroup("advanced", List(
    bulkSizeParameter, schemaSampleSizeParameter, selectorParameter, createDatabaseOnSaveParameter
  ))

  val parameterGroups = List(generalGroup, advancedGroup)
}