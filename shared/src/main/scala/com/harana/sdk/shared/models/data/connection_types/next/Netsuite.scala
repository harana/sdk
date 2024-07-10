package com.harana.sdk.shared.models.data.connection_types.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup, ParameterValue}
import com.harana.sdk.shared.models.data.{ConnectionType, SyncDirection}

import scala.scalajs.reflect.annotation.EnableReflectiveInstantiation

@EnableReflectiveInstantiation
class Netsuite extends ConnectionType {

  val id = "A85D2408-55E1-4066-A019-DC7843D11EEB"

  val emailParameter = Parameter.String("email", required = true)
  val passwordParameter = Parameter.Password("password", required = true)
  val accountParameter = Parameter.String("account", required = true)
  val applicationIdParameter = Parameter.String("applicationId", required = true)
  val roleIdParameter = Parameter.Long("roleId", default = Some(ParameterValue.Long(3)))
  val generalGroup = ParameterGroup("general", List(emailParameter, passwordParameter, accountParameter, applicationIdParameter, roleIdParameter))

  val parameterGroups = List(generalGroup)
  val syncDirection = SyncDirection.Bidirectional

}