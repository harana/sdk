package com.harana.sdk.shared.models.data.connection_types.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.ConnectionType

import scala.scalajs.reflect.annotation.EnableReflectiveInstantiation

@EnableReflectiveInstantiation
class Zuora extends ConnectionType {

  // General
  val instanceUrlParameter = Parameter.Uri("instanceUrl", required = true)
  val usernameParameter = Parameter.String("username", required = true)
  val passwordParameter = Parameter.Password("password", required = true)
  val generalGroup = ParameterGroup("general", List(instanceUrlParameter, usernameParameter, passwordParameter))

  val parameterGroups = List(generalGroup)
}