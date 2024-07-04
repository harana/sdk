package com.harana.sdk.shared.models.data.connection_types.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.{ConnectionType, JdbcConnectionType}

import scala.scalajs.reflect.annotation.EnableReflectiveInstantiation

@EnableReflectiveInstantiation
class OrientDb extends JdbcConnectionType {

  val hostParameter = Parameter.IPAddress("host", port = true, portDefault = Some(2424))
  val generalGroup = ParameterGroup("general", List(hostParameter, usernameParameter, passwordParameter))
  val parameterGroups = List(generalGroup, jdbcAdvancedGroup)

}