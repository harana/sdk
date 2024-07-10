package com.harana.sdk.shared.models.data.connection_types

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.{ConnectionType, SyncDirection}
import com.harana.sdk.shared.models.common.Parameter

class Sftp extends ConnectionType {

  val id = "4EDAD65D-5779-4D41-84BD-1D24BC974D79"

  // General
  val hostParameter = Parameter.IPAddress("host", port = true, portDefault = Some(22), required = true)
  val usernameParameter = Parameter.String("username", required = true)
  val passwordParameter = Parameter.Password("password", required = true)
  val generalGroup = ParameterGroup("general", List(hostParameter, usernameParameter, passwordParameter))

  val parameterGroups = List(generalGroup)
  val syncDirection = SyncDirection.Bidirectional

}