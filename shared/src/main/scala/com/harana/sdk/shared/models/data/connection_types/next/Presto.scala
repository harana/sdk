package com.harana.sdk.shared.models.data.connection_types.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.ConnectionType

import scala.scalajs.reflect.annotation.EnableReflectiveInstantiation

@EnableReflectiveInstantiation
class Presto extends ConnectionType {

  val id = "4D5957F3-1068-4841-BFB0-CA0F058696F8"

  // General
  val hostsParameter = Parameter.IPAddressList("hosts", port = true, portDefault = Some(8091), required = true)
  val usernameParameter = Parameter.String("username", required = true)
  val passwordParameter = Parameter.Password("password", required = true)
  val generalGroup = ParameterGroup("general", List(hostsParameter, usernameParameter, passwordParameter))

  val parameterGroups = List(generalGroup)

}