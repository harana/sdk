package com.harana.sdk.shared.models.data.datasourcetypes.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup, ParameterValue}
import com.harana.sdk.shared.models.data.DataSourceType

import scala.scalajs.reflect.annotation.EnableReflectiveInstantiation

@EnableReflectiveInstantiation
class Clickhouse extends DataSourceType {

  // General
  val hostsParameter = Parameter.IPAddressList("hosts", port = true, portDefault = Some(8123), required = true)
  val usernameParameter = Parameter.String("username", required = true)
  val passwordParameter = Parameter.Password("password", required = true)
  val generalGroup = ParameterGroup("general", List(hostsParameter, usernameParameter, passwordParameter))

  // Advanced
  val maxConnectionsPerExecutorParameter = Parameter.Long("maxConnectionsPerExecutor", default = Some(ParameterValue.Long(5)))
  val enableMetricsParameter = Parameter.Boolean("enableMetrics", default = Some(ParameterValue.Boolean(false)))
  val socketTimeoutParameter = Parameter.Long("socketTimeout", default = Some(ParameterValue.Long(10000)))
  val autoDiscoveryParameter = Parameter.Boolean("autoDiscovery", default = Some(ParameterValue.Boolean(false)))
  val advancedGroup = ParameterGroup("advanced", List(maxConnectionsPerExecutorParameter, enableMetricsParameter, socketTimeoutParameter, autoDiscoveryParameter))

  val parameterGroups = List(generalGroup, advancedGroup)

}