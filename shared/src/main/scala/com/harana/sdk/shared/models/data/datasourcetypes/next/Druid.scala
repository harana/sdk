package com.harana.sdk.shared.models.data.datasourcetypes.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup, ParameterValue}
import com.harana.sdk.shared.models.data.DataSourceType

import scala.scalajs.reflect.annotation.EnableReflectiveInstantiation

@EnableReflectiveInstantiation
class Druid extends DataSourceType {

  // General
  val zookeeperHostParameter = Parameter.IPAddress("zookeeperHost", port = true, portDefault = Some(2181), required = true)
  val datasourceNameParameter = Parameter.String("datasourceName", required = true)
  val generalGroup = ParameterGroup("general", List(zookeeperHostParameter, datasourceNameParameter))

  // Advanced
  val columnInfoParameter = Parameter.String("columnInfo", required = true)
  val zookeeperSessionTimeoutParameter = Parameter.Long("zookeeperSessionTimeout", default = Some(ParameterValue.Long(30000)))
  val zookeeperCompressionParameter = Parameter.Boolean("zookeeperCompression", default = Some(ParameterValue.Boolean(true)))
  val zookeeperDruidPath = Parameter.String("zookeeperDruidPath", default = Some(ParameterValue.String("/druid")))
  val zookeeperQualifyDiscoveryNamesParameter = Parameter.Boolean("zookeeperQualifyDiscoveryNames", default = Some(ParameterValue.Boolean(true)))
  val queryGranularityParameter = Parameter.String("queryGranularity", default = Some(ParameterValue.String("al")))
  val maxConnectionsPerRouteParameter = Parameter.Long("maxConnectionsPerRoute", default = Some(ParameterValue.Long(20)))
  val maxConnectionsParameter = Parameter.Long("maxConnections", default = Some(ParameterValue.Long(20)))
  val loadMetadataFromAllSegmentsParameter = Parameter.Boolean("loadMetadataFromAllSegments", default = Some(ParameterValue.Boolean(true)))
  val timeZoneParameter = Parameter.String("timeZone", default = Some(ParameterValue.String("UTC")))
  val useV2GroupByEngineParameter = Parameter.Boolean("useV2GroupByEngine", default = Some(ParameterValue.Boolean(false)))
  val useSmileParameter = Parameter.Boolean("useSmile", default = Some(ParameterValue.Boolean(false)))
  val advancedGroup = ParameterGroup("advanced", List(columnInfoParameter, zookeeperSessionTimeoutParameter, zookeeperCompressionParameter, zookeeperDruidPath,
    zookeeperQualifyDiscoveryNamesParameter, queryGranularityParameter, maxConnectionsPerRouteParameter, maxConnectionsParameter,
    loadMetadataFromAllSegmentsParameter, timeZoneParameter, useV2GroupByEngineParameter, useSmileParameter))

  val parameterGroups = List(generalGroup, advancedGroup)
}