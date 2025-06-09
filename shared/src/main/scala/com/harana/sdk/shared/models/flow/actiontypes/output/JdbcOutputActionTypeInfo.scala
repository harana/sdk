package com.harana.sdk.shared.models.flow.actiontypes.output

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.common.ParameterValue.given

abstract class JdbcOutputActionTypeInfo extends OutputActionTypeInfo {

  val databaseParameter = Parameter.String("database")
  val tableParameter = Parameter.String("table")
  val jdbcGeneralParameters = List(databaseParameter, tableParameter)

  val batchSizeParameter = Parameter.Long("batch-size", 1000)
  val jdbcAdvancedGroup = ParameterGroup("advanced", List(saveModeParameter, batchSizeParameter))
}