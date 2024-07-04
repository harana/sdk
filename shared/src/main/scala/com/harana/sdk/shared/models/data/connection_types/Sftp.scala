package com.harana.sdk.shared.models.data.connection_types

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.ConnectionType
import com.harana.sdk.shared.models.common.Parameter

class Sftp extends ConnectionType {

  // General
  val hostParameter = Parameter.IPAddress("host", port = true, portDefault = Some(22), required = true)
  val usernameParameter = Parameter.String("username", required = true)
  val passwordParameter = Parameter.Password("password", required = true)
  val generalGroup = ParameterGroup("general", List(hostParameter, usernameParameter, passwordParameter))

  val parameterGroups = List(generalGroup)

}