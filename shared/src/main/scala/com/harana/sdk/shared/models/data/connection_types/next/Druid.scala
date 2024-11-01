package com.harana.sdk.shared.models.data.connection_types.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.{ConnectionType, SyncDirection}

import scala.scalajs.reflect.annotation.EnableReflectiveInstantiation

@EnableReflectiveInstantiation
class Druid extends ConnectionType {

  val id = "EEB1B73A-21E9-424E-A3C6-150ACBD9C9FD"

  // General
  val zookeeperHostParameter = Parameter.IPAddress("zookeeperHost", port = true, portDefault = Some(2181), required = true)
  val datasourceNameParameter = Parameter.String("datasourceName", required = true)
  val generalGroup = ParameterGroup("general", List(zookeeperHostParameter, datasourceNameParameter))

  // Advanced
  val columnInfoParameter = Parameter.String("columnInfo", required = true)
  val zookeeperSessionTimeoutParameter = Parameter.Long("zookeeperSessionTimeout", default = Some(30000))
  val zookeeperCompressionParameter = Parameter.Boolean("zookeeperCompression", default = Some(true))
  val zookeeperDruidPath = Parameter.String("zookeeperDruidPath", default = Some("/druid"))
  val zookeeperQualifyDiscoveryNamesParameter = Parameter.Boolean("zookeeperQualifyDiscoveryNames", default = Some(true))
  val queryGranularityParameter = Parameter.String("queryGranularity", default = Some("al"))
  val maxConnectionsPerRouteParameter = Parameter.Long("maxConnectionsPerRoute", default = Some(20))
  val maxConnectionsParameter = Parameter.Long("maxConnections", default = Some(20))
  val loadMetadataFromAllSegmentsParameter = Parameter.Boolean("loadMetadataFromAllSegments", default = Some(true))
  val timeZoneParameter = Parameter.String("timeZone", default = Some("UTC"))
  val useV2GroupByEngineParameter = Parameter.Boolean("useV2GroupByEngine", default = Some(false))
  val useSmileParameter = Parameter.Boolean("useSmile", default = Some(false))
  val advancedGroup = ParameterGroup("advanced", List(columnInfoParameter, zookeeperSessionTimeoutParameter, zookeeperCompressionParameter, zookeeperDruidPath,
    zookeeperQualifyDiscoveryNamesParameter, queryGranularityParameter, maxConnectionsPerRouteParameter, maxConnectionsParameter,
    loadMetadataFromAllSegmentsParameter, timeZoneParameter, useV2GroupByEngineParameter, useSmileParameter))

  val parameterGroups = List(generalGroup, advancedGroup)
  val syncDirection = SyncDirection.Bidirectional

}