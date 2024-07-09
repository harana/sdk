package com.harana.sdk.shared.models.data.connection_types.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup, ParameterValue}
import com.harana.sdk.shared.models.data.ConnectionType

import scala.scalajs.reflect.annotation.EnableReflectiveInstantiation

@EnableReflectiveInstantiation
class Redis extends ConnectionType {

  val id = "97EC596D-1D9C-4EAA-A9E1-D393AF378B32"

  // General
  val hostParameter = Parameter.IPAddress("host", port = true, portDefault = Some(6379), required = true)
  val usernameParameter = Parameter.String("username", required = true)
  val passwordParameter = Parameter.Password("password", required = true)
  val generalGroup = ParameterGroup("general", List(hostParameter, usernameParameter, passwordParameter))

  // Advanced
  val connectionTimeoutParameter = Parameter.Long("connectionTimeout", default = Some(ParameterValue.Long(2000)))
  val maxPipelineSizeParameter = Parameter.Long("maxPipelineSize", default = Some(ParameterValue.Long(100)))
  val scanCountParameter = Parameter.Long("scanCount", default = Some(ParameterValue.Long(100)))
  val advancedGroup = ParameterGroup("advanced", List(connectionTimeoutParameter, maxPipelineSizeParameter, scanCountParameter))

  // Groups
  val parameterGroups = List(generalGroup, advancedGroup)

}