package com.harana.sdk.shared.models.data.datasourcetypes

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.{JdbcDataSourceType}

class Redshift extends JdbcDataSourceType {

  val hostParameter = Parameter.IPAddress("host", required = true, port = true, portDefault = Some(1521))
  val generalGroup = ParameterGroup("general", List(hostParameter, usernameParameter, passwordParameter))
  val parameterGroups = List(generalGroup, jdbcAdvancedGroup)

}