package com.harana.sdk.shared.models.data.connection_types.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup, ParameterValue}
import com.harana.sdk.shared.models.data.{ConnectionType, SyncDirection}

import scala.scalajs.reflect.annotation.EnableReflectiveInstantiation

@EnableReflectiveInstantiation
class Kinetica extends ConnectionType {

  val id = "93AAD83A-98FD-4A11-BA41-75ABF6E86482"

  // General
  val hostParameter = Parameter.IPAddress("host", port = true, portDefault = Some(9191), required = true)
  val usernameParameter = Parameter.String("username", required = true)
  val passwordParameter = Parameter.Password("password", required = true)
  val generalGroup = ParameterGroup("general", List(hostParameter, usernameParameter, passwordParameter))

  // Advanced
  val primaryHostParameter = Parameter.IPAddress("primaryHost", port = true, portDefault = Some(9191), required = true)
  val streamHostParameter = Parameter.IPAddress("streamHost", port = true, portDefault = Some(9092), required = true)
  val retryCountParameter = Parameter.Long("retryCount")
  val timeoutParameter = Parameter.Long("timeout", default = Some(ParameterValue.Long(1800)))
  val advancedGroup = ParameterGroup("advanced", List(primaryHostParameter, streamHostParameter, retryCountParameter, timeoutParameter))

  val parameterGroups = List(generalGroup, advancedGroup)
  val syncDirection = SyncDirection.Bidirectional

}