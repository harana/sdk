package com.harana.sdk.shared.models.data.datasourcetypes.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.DataSourceType

import scala.scalajs.reflect.annotation.EnableReflectiveInstantiation

@EnableReflectiveInstantiation
class Salesforce extends DataSourceType {

  // General
  val usernameParameter = Parameter.String("username", required = true)
  val passwordParameter = Parameter.Password("password", required = true)
  val generalGroup = ParameterGroup("general", List(usernameParameter, passwordParameter))

  // Advanced
  val versionParameter = Parameter.String("version")
  val advancedGroup = ParameterGroup("advanced", List(versionParameter))

  val parameterGroups = List(generalGroup, advancedGroup)
}