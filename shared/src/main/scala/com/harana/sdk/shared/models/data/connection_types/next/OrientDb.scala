package com.harana.sdk.shared.models.data.connection_types.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.{ConnectionType, JdbcConnectionType, SyncDirection}

import scala.scalajs.reflect.annotation.EnableReflectiveInstantiation

@EnableReflectiveInstantiation
class OrientDb extends JdbcConnectionType {

  val id = "264E2721-0AF0-4627-80E8-1A392885D217"

  val hostParameter = Parameter.IPAddress("host", port = true, portDefault = Some(2424))
  val generalGroup = ParameterGroup("general", List(hostParameter, usernameParameter, passwordParameter))
  val parameterGroups = List(generalGroup, jdbcAdvancedGroup)
  val syncDirection = SyncDirection.Bidirectional

}