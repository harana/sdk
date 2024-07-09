package com.harana.sdk.shared.models.flow.actiontypes.input.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.ConnectionTypes
import com.harana.sdk.shared.models.data.ConnectionTypes.Cloudant
import com.harana.sdk.shared.models.flow.actiontypes.input.InputActionTypeInfo

class GetCloudantInfo extends InputActionTypeInfo {

  val id = "18563E59-ECFB-4A9A-8D0F-598C16C03F65"

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
  val schemaSampleSizeParameter = Cloudant.schemaSampleSizeParameter
  val selectorParameter = Cloudant.selectorParameter
  val createDatabaseOnSaveParameter = Cloudant.createDatabaseOnSaveParameter

  val advancedGroup = ParameterGroup("advanced", List(
    schemaSampleSizeParameter, selectorParameter, createDatabaseOnSaveParameter
  ))

  val parameterGroups = List(generalGroup, advancedGroup)
}