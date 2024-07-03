package com.harana.sdk.shared.models.data.datasourcetypes

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup, ParameterValue}
import com.harana.sdk.shared.models.data.{DataSourceType, JdbcDataSourceType}

class SqlServer extends JdbcDataSourceType {

  // General
  val hostParameter = Parameter.IPAddress("host", required = true, port = true, portDefault = Some(1433))
  val generalGroup = ParameterGroup("general", List(hostParameter) ++ jdbcGeneralParameters)

  // Advanced
  val reliabilityLevelParameter = Parameter.String("reliability-level", options = List(
    ("best-effort", "BEST_EFFORT"),
    ("no-duplicates", "NO_DUPLICATES")
  ))
  val dataPoolDataSourceParameter = Parameter.String("datapool-datasource")
  val tableLockParameter = Parameter.Boolean("table-lock", Some(ParameterValue.Boolean(false)))
  val advancedGroup = ParameterGroup("advanced", jdbcAdvancedParameters ++ List(reliabilityLevelParameter, dataPoolDataSourceParameter, tableLockParameter))

  val parameterGroups = List(generalGroup, advancedGroup)
}