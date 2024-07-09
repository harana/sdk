package com.harana.sdk.shared.models.data.connection_types.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup, ParameterValue}
import com.harana.sdk.shared.models.data.ConnectionType

import scala.scalajs.reflect.annotation.EnableReflectiveInstantiation

@EnableReflectiveInstantiation
class Influx extends ConnectionType {

  val id = "D51084DE-9528-4DB1-B45A-497E1E598677"

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