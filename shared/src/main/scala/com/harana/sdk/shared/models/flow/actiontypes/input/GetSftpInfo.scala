package com.harana.sdk.shared.models.flow.actiontypes.input

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup, ParameterValue}
import com.harana.sdk.shared.models.data.ConnectionTypes
import com.harana.sdk.shared.models.flow.actiontypes._

class GetSftpInfo extends InputActionTypeInfo {

  val tags = Set()
  val dataSourceType = ConnectionTypes.Sftp

  val dataSourceParameter = Parameter.Connection("data-source", dataSourceType, required = true)
  val fileTypeParameter = Parameter.String("file-type", options = List(
    ("avro", ParameterValue.String("avro")),
    ("csv", ParameterValue.String("csv")),
    ("json", ParameterValue.String("json")),
    ("parquet", ParameterValue.String("parquet")),
    ("text", ParameterValue.String("txt"))
  ), required = true)
  val generalGroup = ParameterGroup("general", List(dataSourceParameter, fileTypeParameter, pathParameter, fileNameParameter))

  val inferSchemaParameter = Parameter.Boolean("infer-schema")
  val headerParameter = Parameter.Boolean("header")
  val delimiterParameter = Parameter.String("delimiter", Some(ParameterValue.String(",")))
  val quoteParameter = Parameter.String("quote", Some(ParameterValue.String("\"")))
  val escapeParameter = Parameter.String("escape", Some(ParameterValue.String("\\")))
  val multiLineParameter = Parameter.Boolean("multi-line")
  val csvGroup = ParameterGroup("csv", List(inferSchemaParameter, headerParameter, delimiterParameter, quoteParameter, escapeParameter, multiLineParameter))

  val parameterGroups = List(generalGroup, logGroup)
}