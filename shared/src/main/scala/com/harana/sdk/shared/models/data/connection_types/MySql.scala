package com.harana.sdk.shared.models.data.connection_types

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.JdbcConnectionType

class MySql extends JdbcConnectionType {

  val id = "0396E8D6-700F-45B1-8C5B-CCF7B76AA4F3"

  val hostParameter = Parameter.IPAddress("host", required = true, port = true, portDefault = Some(3306))
  val generalGroup = ParameterGroup("general", List(hostParameter, usernameParameter, passwordParameter))
  val parameterGroups = List(generalGroup, jdbcAdvancedGroup)

}