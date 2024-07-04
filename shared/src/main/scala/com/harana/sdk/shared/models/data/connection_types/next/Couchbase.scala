package com.harana.sdk.shared.models.data.connection_types.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.ConnectionType

import scala.scalajs.reflect.annotation.EnableReflectiveInstantiation

@EnableReflectiveInstantiation
class Couchbase extends ConnectionType {

  val id = "FEFC3D7D-2ED3-4FBB-9637-12FE8C715198"

  // General
  val hostsParameter = Parameter.IPAddressList("hosts", port = true, portDefault = Some(8091), required = true)
  val usernameParameter = Parameter.String("username", required = true)
  val passwordParameter = Parameter.Password("password", required = true)
  val generalGroup = ParameterGroup("general", List(hostsParameter, usernameParameter, passwordParameter))

  val parameterGroups = List(generalGroup)

}