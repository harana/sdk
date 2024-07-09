package com.harana.sdk.shared.models.data.connection_types.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.ConnectionType

import scala.scalajs.reflect.annotation.EnableReflectiveInstantiation

@EnableReflectiveInstantiation
class Zuora extends ConnectionType {

  val id = "1331C49E-3DC9-47A7-93DE-357A803FC755"

  // General
  val instanceUrlParameter = Parameter.Uri("instanceUrl", required = true)
  val usernameParameter = Parameter.String("username", required = true)
  val passwordParameter = Parameter.Password("password", required = true)
  val generalGroup = ParameterGroup("general", List(instanceUrlParameter, usernameParameter, passwordParameter))

  val parameterGroups = List(generalGroup)

}