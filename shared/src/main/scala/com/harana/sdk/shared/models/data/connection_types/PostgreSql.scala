package com.harana.sdk.shared.models.data.connection_types

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.{ConnectionType, JdbcConnectionType}

class PostgreSql extends JdbcConnectionType {

  val id = "8E34DB6C-78A7-4397-9B15-75979AC218E6"

  val hostParameter = Parameter.IPAddress("host", required = true, port = true, portDefault = Some(5439))
  val generalGroup = ParameterGroup("general", List(hostParameter, usernameParameter, passwordParameter))
  val parameterGroups = List(generalGroup, jdbcAdvancedGroup)

}