package com.harana.sdk.shared.models.data.connection_types

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.{ConnectionType, JdbcConnectionType}

class Oracle extends JdbcConnectionType {

  val hostParameter = Parameter.IPAddress("host", required = true, port = true, portDefault = Some(1521))
  val generalGroup = ParameterGroup("general", List(hostParameter, usernameParameter, passwordParameter))
  val parameterGroups = List(generalGroup, jdbcAdvancedGroup)

}