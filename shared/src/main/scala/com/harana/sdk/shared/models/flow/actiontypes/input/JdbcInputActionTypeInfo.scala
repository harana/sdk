package com.harana.sdk.shared.models.flow.actiontypes.input

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}

abstract class JdbcInputActionTypeInfo extends InputActionTypeInfo {

  val databaseParameter = Parameter.String("database")
  val tableParameter = Parameter.String("table")
  val queryParameter = Parameter.String("query", multiLine = true)
  val jdbcGeneralParameters = List(databaseParameter, tableParameter, queryParameter)

  val partitionColumnParameter = Parameter.String("partition-column")
  val partitionLowerBoundParameter = Parameter.String("lower-bound")
  val partitionUpperBoundParameter = Parameter.String("upper-bound")
  val fetchSizeParameter = Parameter.Long("fetch-size")
  val jdbcAdvancedGroup = ParameterGroup("advanced", List(partitionColumnParameter, partitionLowerBoundParameter, partitionUpperBoundParameter, fetchSizeParameter))

}