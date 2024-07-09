package com.harana.sdk.shared.models.flow.actiontypes.input

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup, ParameterValue}
import com.harana.sdk.shared.models.data.ConnectionTypes
import com.harana.sdk.shared.models.flow.actiontypes.logGroup

class GetSnowflakeInfo extends InputActionTypeInfo {

  val id = "78AE6457-21C1-49B1-BA9D-A8F733256344"

  val tags = Set()

  // General
  val dataSourceType = ConnectionTypes.Snowflake
  val dataSourceParameter = Parameter.Connection("data-source", dataSourceType, required = true)
  val modeParameter = Parameter.String("mode", required = true, options = List(
    ("query", ParameterValue.String("query")),
    ("table", ParameterValue.String("table"))
  ))
  val queryParameter = Parameter.String("query", multiLine = true)
  val tableParameter = Parameter.String("table")
  val generalGroup = ParameterGroup("general", List(dataSourceParameter, modeParameter, queryParameter, tableParameter))

  // Advanced
  val compressParameter = Parameter.Boolean("compress")
  val maxFileSizeParameter = Parameter.Long("max-file-size", Some(ParameterValue.Long(10)))
  val parallelismParameter = Parameter.Long("parallelism", Some(ParameterValue.Long(4)))
  val advancedGroup = ParameterGroup("advanced", List(compressParameter, maxFileSizeParameter, parallelismParameter))

  val parameterGroups = List(generalGroup, advancedGroup, logGroup)
} 