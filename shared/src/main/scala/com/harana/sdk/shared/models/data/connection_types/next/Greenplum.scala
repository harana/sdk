package com.harana.sdk.shared.models.data.connection_types.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.ConnectionType

import scala.scalajs.reflect.annotation.EnableReflectiveInstantiation

@EnableReflectiveInstantiation
class Greenplum extends ConnectionType {

  val id = "8676D520-7163-441E-B8A3-A585613800AB"

  val hostParameter = Parameter.IPAddress("host", port = true, portDefault = Some(5432))
  val usernameParameter = Parameter.String("username")
  val passwordParameter = Parameter.Password("password")
  val schemaParameter = Parameter.String("schema")
  val generalGroup = ParameterGroup("general", List(hostParameter, usernameParameter, passwordParameter, schemaParameter))

  val parameterGroups = List(generalGroup)

}