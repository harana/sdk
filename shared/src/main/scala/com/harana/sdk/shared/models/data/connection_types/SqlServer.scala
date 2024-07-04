package com.harana.sdk.shared.models.data.connection_types

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup, ParameterValue}
import com.harana.sdk.shared.models.data.{ConnectionType, JdbcConnectionType}

class SqlServer extends JdbcConnectionType {

  // General
  val hostParameter = Parameter.IPAddress("host", required = true, port = true, portDefault = Some(1433))
  val generalGroup = ParameterGroup("general", List(hostParameter) ++ jdbcGeneralParameters)

  // Advanced
  val reliabilityLevelParameter = Parameter.String("reliability-level", options = List(
    ("best-effort", ParameterValue.String("BEST_EFFORT")),
    ("no-duplicates", ParameterValue.String("NO_DUPLICATES"))
  ))
  val dataPoolConnectionParameter = Parameter.String("datapool-datasource")
  val tableLockParameter = Parameter.Boolean("table-lock", Some(ParameterValue.Boolean(false)))
  val advancedGroup = ParameterGroup("advanced", jdbcAdvancedParameters ++ List(reliabilityLevelParameter, dataPoolConnectionParameter, tableLockParameter))

  val parameterGroups = List(generalGroup, advancedGroup)
}