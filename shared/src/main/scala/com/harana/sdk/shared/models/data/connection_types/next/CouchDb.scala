package com.harana.sdk.shared.models.data.connection_types.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup, ParameterValue}
import com.harana.sdk.shared.models.data.{ConnectionType, SyncDirection}

import scala.scalajs.reflect.annotation.EnableReflectiveInstantiation

@EnableReflectiveInstantiation
class CouchDb extends ConnectionType {

  val id = "D7454B03-0EE9-4056-BAC7-00C221B4DE35"

  // General
  val hostParameter = Parameter.IPAddress("host", required = true)
  val sslParameter = Parameter.Boolean("ssl", default = Some(ParameterValue.Boolean(false)))
  val usernameParameter = Parameter.String("username", required = true)
  val passwordParameter = Parameter.Password("password", required = true)
  val generalGroup = ParameterGroup("general", List(hostParameter, sslParameter, usernameParameter, passwordParameter))

  // Advanced
  val queryTimeoutParameter = Parameter.Long("queryTimeout", default = Some(ParameterValue.Long(60000)))
  val advancedGroup = ParameterGroup("advanced", List(queryTimeoutParameter))

  val parameterGroups = List(generalGroup, advancedGroup)
  val syncDirection = SyncDirection.Bidirectional

}