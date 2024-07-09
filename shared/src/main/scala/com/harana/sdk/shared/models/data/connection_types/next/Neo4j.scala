package com.harana.sdk.shared.models.data.connection_types.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup, ParameterValue}
import com.harana.sdk.shared.models.data.ConnectionType

import scala.scalajs.reflect.annotation.EnableReflectiveInstantiation

@EnableReflectiveInstantiation
class Neo4j extends ConnectionType {

  val id = "356541DB-0BAC-48D4-BEC1-C7C502D3BDDD"

  // General
  val hostParameter = Parameter.IPAddress("host", port = true, portDefault = Some(7473), required = true)
  val usernameParameter = Parameter.String("username", required = true)
  val passwordParameter = Parameter.Password("password", required = true)
  val generalGroup = ParameterGroup("general", List(hostParameter, usernameParameter, passwordParameter))

  // Password
  val encryptedParameter = Parameter.Boolean("encrypted", default = Some(ParameterValue.Boolean(false)))
  val advancedGroup = ParameterGroup("advanced", List(encryptedParameter))

  val parameterGroups = List(generalGroup, advancedGroup)

}