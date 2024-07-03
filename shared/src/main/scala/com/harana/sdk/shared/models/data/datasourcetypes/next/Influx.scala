package com.harana.sdk.shared.models.data.datasourcetypes.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup, ParameterValue}
import com.harana.sdk.shared.models.data.DataSourceType

import scala.scalajs.reflect.annotation.EnableReflectiveInstantiation

@EnableReflectiveInstantiation
class Influx extends DataSourceType {

  // General
  val hostParameter = Parameter.IPAddress("host", port = true, portDefault = Some(8086))
  val usernameParameter = Parameter.String("username")
  val passwordParameter = Parameter.Password("password")
  val sslParameter = Parameter.Boolean("ssl", default = Some(ParameterValue.Boolean(false)))
  val generalGroup = ParameterGroup("general", List(hostParameter, usernameParameter, passwordParameter, sslParameter))

  // Advanced
  val compressParameter = Parameter.Boolean("compress", default = Some(ParameterValue.Boolean(false)))
  val advancedGroup = ParameterGroup("advanced", List(compressParameter))

  val parameterGroups = List(generalGroup, advancedGroup)
}