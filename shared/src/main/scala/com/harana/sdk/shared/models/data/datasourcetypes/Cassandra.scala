package com.harana.sdk.shared.models.data.datasourcetypes

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup, ParameterValue}
import com.harana.sdk.shared.models.data.DataSourceType

class Cassandra extends DataSourceType {

  // General
  val hostsParameter = Parameter.IPAddressList("hosts", required = true)
  val usernameParameter = Parameter.String("username", required = true)
  val passwordParameter = Parameter.Password("password", required = true)
  val sslParameter = Parameter.Boolean("ssl")
  val generalGroup = ParameterGroup("general", List(hostsParameter, usernameParameter, passwordParameter, sslParameter))

  // Advanced
  val compressionParameter = Parameter.String("compression", options = List(
    ("lz4", "lz4"),
    ("snappy", "snappy"),
    ("none", "none")))
  val minReconnectionDelayParameter = Parameter.Long("min-reconnection-delay", Some(ParameterValue.Long(1000)))
  val maxReconnectionDelayParameter = Parameter.Long("max-reconnection-delay", Some(ParameterValue.Long(60000)))
  val connectionTimeoutParameter = Parameter.Long("connection-timeout", Some(ParameterValue.Long(5000)))
  val queryRetryCountParameter = Parameter.Long("query-retry-count", Some(ParameterValue.Long(60)))
  val readTimeoutParameter = Parameter.Long("read-timeout", Some(ParameterValue.Long(120000)))
  val advancedGroup = ParameterGroup("advanced", List(compressionParameter, minReconnectionDelayParameter, maxReconnectionDelayParameter, connectionTimeoutParameter, queryRetryCountParameter, readTimeoutParameter))

  val parameterGroups = List(generalGroup, advancedGroup)
}