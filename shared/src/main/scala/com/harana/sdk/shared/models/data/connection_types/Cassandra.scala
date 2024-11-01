package com.harana.sdk.shared.models.data.connection_types

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.{ConnectionType, SyncDirection}

class Cassandra extends ConnectionType {

  val id = "EA338258-5644-4CC5-AB36-74F89B9A857C"

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
    ("none", "none")
  ))
  val minReconnectionDelayParameter = Parameter.Long("min-reconnection-delay", Some(1000))
  val maxReconnectionDelayParameter = Parameter.Long("max-reconnection-delay", Some(60000))
  val connectionTimeoutParameter = Parameter.Long("connection-timeout", Some(5000))
  val queryRetryCountParameter = Parameter.Long("query-retry-count", Some(60))
  val readTimeoutParameter = Parameter.Long("read-timeout", Some(120000))
  val advancedGroup = ParameterGroup("advanced", List(compressionParameter, minReconnectionDelayParameter, maxReconnectionDelayParameter, connectionTimeoutParameter, queryRetryCountParameter, readTimeoutParameter))

  val parameterGroups = List(generalGroup, advancedGroup)
  val syncDirection = SyncDirection.Bidirectional

}