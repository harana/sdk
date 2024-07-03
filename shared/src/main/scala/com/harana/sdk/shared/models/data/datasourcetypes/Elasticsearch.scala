package com.harana.sdk.shared.models.data.datasourcetypes

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup, ParameterValue}
import com.harana.sdk.shared.models.data.DataSourceType

class Elasticsearch extends DataSourceType {

  // General
  val hostsParameter = Parameter.IPAddressList("hosts", required = true, port = true, portDefault = Some(9600))
  val sslParameter = Parameter.Boolean("ssl", Some(ParameterValue.Boolean(false)), required = true)
  val usernameParameter = Parameter.String("username", required = true)
  val passwordParameter = Parameter.Password("password", required = true)
  val generalGroup = ParameterGroup("general", List(hostsParameter, sslParameter, usernameParameter, passwordParameter))

  // Advanced
  val queryRetriesParameter = Parameter.Long("query-retries", Some(ParameterValue.Long(3)))
  val queryTimeoutParameter = Parameter.Long("query-timeout", Some(ParameterValue.Long(60)))
  val discoveryParameter = Parameter.Boolean("discovery")
  val clientOnlyParameter = Parameter.Boolean("client-only")
  val pathPrefixParameter = Parameter.String("path-prefix")
  val autoCreateIndexParameter = Parameter.Boolean("auto-create-index")
  val dataNodesOnlyParameter = Parameter.Boolean("data-nodes-only")
  val ingestNodesOnlyParameter = Parameter.Boolean("ingest-nodes-only")
  val wanNodesOnlyParameter = Parameter.Boolean("wan-nodes-only")
  val resolveHostnameParameter = Parameter.Boolean("resolve-hostname")
  val advancedGroup = ParameterGroup("advanced", List(
    queryRetriesParameter, queryTimeoutParameter, discoveryParameter, clientOnlyParameter, pathPrefixParameter,
    autoCreateIndexParameter, dataNodesOnlyParameter, ingestNodesOnlyParameter, wanNodesOnlyParameter, resolveHostnameParameter
  ))

  // Groups
  val parameterGroups = List(generalGroup, advancedGroup)
}