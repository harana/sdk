package com.harana.sdk.shared.models.flow.actiontypes.input.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.ConnectionTypes
import com.harana.sdk.shared.models.flow.actiontypes.input.InputActionTypeInfo

class GetCephInfo extends InputActionTypeInfo {

  val id = "B0861CD8-0051-4003-8199-55FF737E9ADA"

  val tags = Set()
  val dataSourceType = ConnectionTypes.Ceph
  val dataSourceParameter = Parameter.Connection("data-source", dataSourceType, required = true)

  // General
  val databaseParameter = Parameter.String("database", required = true)
  val indexParameter = Parameter.String("index", required = true)
  val viewParameter = Parameter.String("view")
  val generalGroup = ParameterGroup("general", List(databaseParameter, indexParameter, viewParameter))

  // Advanced
  val bulkSizeParameter = Parameter.Long("bulkSize", placeholder = Some(200))
  val schemaSampleSizeParameter = Parameter.Long("schemaSampleSize", placeholder = Some(-1))
  val selectorParameter = Parameter.String("selector")
  val createDatabaseOnSaveParameter = Parameter.Boolean("createDatabaseOnSave")
  val advancedGroup = ParameterGroup("advanced", List(bulkSizeParameter, schemaSampleSizeParameter, selectorParameter, createDatabaseOnSaveParameter))

  val parameterGroups = List(generalGroup, advancedGroup)
}