package com.harana.sdk.shared.models.data.datasourcetypes.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.DataSourceType

import scala.scalajs.reflect.annotation.EnableReflectiveInstantiation

@EnableReflectiveInstantiation
class Greenplum extends DataSourceType {

  val hostParameter = Parameter.IPAddress("host", port = true, portDefault = Some(5432))
  val usernameParameter = Parameter.String("username")
  val passwordParameter = Parameter.Password("password")
  val schemaParameter = Parameter.String("schema")
  val generalGroup = ParameterGroup("general", List(hostParameter, usernameParameter, passwordParameter, schemaParameter))

  val parameterGroups = List(generalGroup)
}