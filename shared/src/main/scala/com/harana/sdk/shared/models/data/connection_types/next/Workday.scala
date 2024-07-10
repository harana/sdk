package com.harana.sdk.shared.models.data.connection_types.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.{ConnectionType, SyncDirection}

import scala.scalajs.reflect.annotation.EnableReflectiveInstantiation

@EnableReflectiveInstantiation
class Workday extends ConnectionType {

  val id = "B543C116-AAA6-4124-A239-66A131CC99EC"

  // General
  val endpointParameter = Parameter.String("endpoint", required = true)
  val usernameParameter = Parameter.String("username", required = true)
  val passwordParameter = Parameter.Password("password", required = true)
  val generalGroup = ParameterGroup("general", List(endpointParameter, usernameParameter, passwordParameter))

  val parameterGroups = List(generalGroup)
  val syncDirection = SyncDirection.Bidirectional
}