package com.harana.sdk.shared.models.flow.actiontypes.output

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.flow.actiontypes.{ActionTypeGroup, logGroup}
import com.harana.sdk.shared.models.data.ConnectionTypes

class PutSnowflakeInfo extends OutputActionTypeInfo {

  val id = "DD256968-2FF0-41E7-B113-00B20ADB7DF7"

  val tags = Set()
  val dataSourceType = ConnectionTypes.Snowflake

  // General
  val dataSourceParameter = Parameter.Connection("data-source", dataSourceType, required = true)
  val databaseParameter = Parameter.String("database", required = true)
  val tableParameter = Parameter.String("table", required = true)
  val generalGroup = ParameterGroup("general", List(dataSourceParameter, databaseParameter, tableParameter, saveModeParameter))

  val parameterGroups = List(generalGroup, logGroup)
}