package com.harana.sdk.shared.models.data.connection_types.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.{ConnectionType, SyncDirection}

import scala.scalajs.reflect.annotation.EnableReflectiveInstantiation

@EnableReflectiveInstantiation
class Salesforce extends ConnectionType {

  val id = "EA5B0057-E216-452F-A148-2794780FBF43"

  // General
  val usernameParameter = Parameter.String("username", required = true)
  val passwordParameter = Parameter.Password("password", required = true)
  val generalGroup = ParameterGroup("general", List(usernameParameter, passwordParameter))

  // Advanced
  val versionParameter = Parameter.String("version")
  val advancedGroup = ParameterGroup("advanced", List(versionParameter))

  val parameterGroups = List(generalGroup, advancedGroup)
  val syncDirection = SyncDirection.Bidirectional

}