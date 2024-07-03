package com.harana.sdk.shared.models.flow.actiontypes.input

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup, ParameterValue}
import com.harana.sdk.shared.models.data.DataSourceTypes
import com.harana.sdk.shared.models.flow.actiontypes.logGroup

class GetSnowflakeInfo extends InputActionTypeInfo {

  val tags = Set()

  // General
  val dataSourceType = DataSourceTypes.Snowflake
  val dataSourceParameter = Parameter.DataSource("data-source", dataSourceType, required = true)
  val modeParameter = Parameter.String("mode", required = true, options = List(
    ("query", "query"),
    ("table", "table")
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