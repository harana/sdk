package com.harana.sdk.shared.models.data

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup, ParameterValue}

abstract class JdbcDataSourceType extends DataSourceType {

  // General
  val usernameParameter = Parameter.String("username", required = true)
  val passwordParameter = Parameter.Password("password", required = true)
  val jdbcGeneralParameters = List(usernameParameter, passwordParameter)

  // Advanced
  val sessionInitStatementParameter = Parameter.String("session-init-statement")
  val numPartitionsParameter = Parameter.String("num-partitions")
  val queryTimeoutParameter = Parameter.Long("query-timeout", default = Some(ParameterValue.Long(0)))
  val isolationLevelParameter = Parameter.String("isolation-level", options = List(
    ("none", "NONE"),
    ("read-committed", "READ_COMMITTED"),
    ("read-uncommitted", "READ_UNCOMMITTED"),
    ("repeatable-read", "REPEATABLE_READ"),
    ("serializable", "SERIALIZABLE")
  ))
  val jdbcAdvancedParameters = List(sessionInitStatementParameter, numPartitionsParameter, queryTimeoutParameter, isolationLevelParameter)
  val jdbcAdvancedGroup = ParameterGroup("advanced", jdbcAdvancedParameters)

}