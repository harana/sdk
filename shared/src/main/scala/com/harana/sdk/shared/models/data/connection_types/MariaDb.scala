package com.harana.sdk.shared.models.data.connection_types

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.{JdbcConnectionType, SyncDirection}

class MariaDb extends JdbcConnectionType {

  val id = "42CE65B7-E398-4F5F-86D7-90DE8338E2A4"

  val hostParameter = Parameter.IPAddress("host", required = true, port = true, portDefault = Some(3306))
  val generalGroup = ParameterGroup("general", List(hostParameter, usernameParameter, passwordParameter))
  val parameterGroups = List(generalGroup, jdbcAdvancedGroup)
  val syncDirection = SyncDirection.Bidirectional

}