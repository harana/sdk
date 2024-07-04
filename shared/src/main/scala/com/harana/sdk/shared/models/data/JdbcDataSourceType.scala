package com.harana.sdk.shared.models.data

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup, ParameterValue}

abstract class JdbcConnectionType extends ConnectionType {

  // General
  val usernameParameter = Parameter.String("username", required = true)
  val passwordParameter = Parameter.Password("password", required = true)
  val jdbcGeneralParameters = List(usernameParameter, passwordParameter)

  // Advanced
  val sessionInitStatementParameter = Parameter.String("session-init-statement")
  val numPartitionsParameter = Parameter.String("num-partitions")
  val queryTimeoutParameter = Parameter.Long("query-timeout", default = Some(ParameterValue.Long(0)))
  val isolationLevelParameter = Parameter.String("isolation-level", options = List(
    ("none", ParameterValue.String("NONE")),
    ("read-committed", ParameterValue.String("READ_COMMITTED")),
    ("read-uncommitted", ParameterValue.String("READ_UNCOMMITTED")),
    ("repeatable-read", ParameterValue.String("REPEATABLE_READ")),
    ("serializable", ParameterValue.String("SERIALIZABLE"))
  ))
  val jdbcAdvancedParameters = List(sessionInitStatementParameter, numPartitionsParameter, queryTimeoutParameter, isolationLevelParameter)
  val jdbcAdvancedGroup = ParameterGroup("advanced", jdbcAdvancedParameters)

}