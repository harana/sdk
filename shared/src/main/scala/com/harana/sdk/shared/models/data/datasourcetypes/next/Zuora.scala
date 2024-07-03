package com.harana.sdk.shared.models.data.datasourcetypes.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.DataSourceType

import scala.scalajs.reflect.annotation.EnableReflectiveInstantiation

@EnableReflectiveInstantiation
class Zuora extends DataSourceType {

  // General
  val instanceUrlParameter = Parameter.Uri("instanceUrl", required = true)
  val usernameParameter = Parameter.String("username", required = true)
  val passwordParameter = Parameter.Password("password", required = true)
  val generalGroup = ParameterGroup("general", List(instanceUrlParameter, usernameParameter, passwordParameter))

  val parameterGroups = List(generalGroup)
}