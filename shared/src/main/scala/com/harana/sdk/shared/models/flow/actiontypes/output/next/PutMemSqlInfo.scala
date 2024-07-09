package com.harana.sdk.shared.models.flow.actiontypes.output.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup, ParameterValue}
import com.harana.sdk.shared.models.data.ConnectionTypes
import com.harana.sdk.shared.models.flow.actiontypes.output.OutputActionTypeInfo

class PutMemSqlInfo extends OutputActionTypeInfo {

  val id = "51FE2117-EBF4-48C3-8502-5E9809486832"

  val tags = Set()
  val dataSourceType = ConnectionTypes.MemSql

  // General
  val dataSourceParameter = Parameter.Connection("data-source", dataSourceType, required = true)
  val databaseParameter = Parameter.String("database", required = true)
  val tableParameter = Parameter.String("table", required = true)
  val generalGroup = ParameterGroup("general", List(dataSourceParameter, databaseParameter, tableParameter))

  // Advanced
  val overwriteBehaviourParameter = Parameter.String("overwriteBehaviour", options = List(
    ("dropAndCreate", ParameterValue.String("dropAndCreate")),
    ("truncate", ParameterValue.String("truncate")),
    ("merge", ParameterValue.String("merge"))
  ))
  val compressionParameter = Parameter.String("compression", options = List(
    ("lz4", ParameterValue.String("LZ4")),
    ("gzip", ParameterValue.String("GZip")),
    ("none", ParameterValue.String("None"))
  ))
  val advancedGroup = ParameterGroup("advanced", List(overwriteBehaviourParameter, compressionParameter))

  val parameterGroups = List(generalGroup, advancedGroup)

}