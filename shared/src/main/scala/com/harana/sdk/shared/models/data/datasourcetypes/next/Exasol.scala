package com.harana.sdk.shared.models.data.datasourcetypes.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup, ParameterValue}
import com.harana.sdk.shared.models.data.DataSourceType

import scala.scalajs.reflect.annotation.EnableReflectiveInstantiation

@EnableReflectiveInstantiation
class Exasol extends DataSourceType {

  // General
  val hostParameter = Parameter.IPAddress("host", port = true, portDefault = Some(8563))
  val usernameParameter = Parameter.String("username")
  val passwordParameter = Parameter.Password("password")
  val generalGroup = ParameterGroup("general", List(hostParameter, usernameParameter, passwordParameter))

  // Advanced
  val maximumDataNodesParameter = Parameter.Long("maximum-data-nodes", default = Some(ParameterValue.Long(200)))
  val advancedGroup = ParameterGroup("advanced", List(maximumDataNodesParameter))

  // Groups
  val parameterGroups = List(generalGroup, advancedGroup)
}