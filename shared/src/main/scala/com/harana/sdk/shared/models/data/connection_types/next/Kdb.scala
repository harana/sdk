package com.harana.sdk.shared.models.data.connection_types.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup, ParameterValue}
import com.harana.sdk.shared.models.data.{ConnectionType, SyncDirection}

import scala.scalajs.reflect.annotation.EnableReflectiveInstantiation

@EnableReflectiveInstantiation
class Kdb extends ConnectionType {

  val id = "D6F4F823-6EFF-41E1-899F-4746F13EE737"

  // General
  val hostParameter = Parameter.IPAddress("host", port = true, portDefault = Some(8086))
  val usernameParameter = Parameter.String("username")
  val passwordParameter = Parameter.Password("password")
  val sslParameter = Parameter.Boolean("ssl", default = Some(ParameterValue.Boolean(false)))
  val generalGroup = ParameterGroup("general", List(hostParameter, usernameParameter, passwordParameter, sslParameter))

  // Advanced
  val queryTimeoutParameter = Parameter.Long("queryTimeout", default = Some(ParameterValue.Long(60)))
  val advancedGroup = ParameterGroup("advanced", List(queryTimeoutParameter))

  val parameterGroups = List(generalGroup, advancedGroup)
  val syncDirection = SyncDirection.Bidirectional

}