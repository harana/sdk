package com.harana.sdk.shared.models.data.connection_types

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.{JdbcConnectionType, SyncDirection}

class Redshift extends JdbcConnectionType {

  val id = "30D933AD-75F9-4B6D-AA17-47547699A12D"

  val hostParameter = Parameter.IPAddress("host", required = true, port = true, portDefault = Some(1521))
  val generalGroup = ParameterGroup("general", List(hostParameter, usernameParameter, passwordParameter))
  val parameterGroups = List(generalGroup, jdbcAdvancedGroup)
  val syncDirection = SyncDirection.Bidirectional

}