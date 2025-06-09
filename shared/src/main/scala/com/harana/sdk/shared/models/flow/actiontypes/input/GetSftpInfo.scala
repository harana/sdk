package com.harana.sdk.shared.models.flow.actiontypes.input

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.ConnectionTypes
import com.harana.sdk.shared.models.flow.actiontypes._
import com.harana.sdk.shared.models.common.ParameterValue.given

class GetSftpInfo extends InputActionTypeInfo {

  val id = "99D0EED6-7382-42F7-B489-35899067F95B"

  val tags = Set()
  val dataSourceType = ConnectionTypes.Sftp

  val dataSourceParameter = Parameter.Connection("data-source", dataSourceType, required = true)
  val fileTypeParameter = Parameter.String("file-type", options = List(
    ("avro", "avro"),
    ("csv", "csv"),
    ("json", "json"),
    ("parquet", "parquet"),
    ("text", "txt")
  ), required = true)
  val generalGroup = ParameterGroup("general", List(dataSourceParameter, fileTypeParameter, pathParameter, fileNameParameter))

  val inferSchemaParameter = Parameter.Boolean("infer-schema")
  val headerParameter = Parameter.Boolean("header")
  val delimiterParameter = Parameter.String("delimiter", ",")
  val quoteParameter = Parameter.String("quote", "\"")
  val escapeParameter = Parameter.String("escape", "\\")
  val multiLineParameter = Parameter.Boolean("multi-line")
  val csvGroup = ParameterGroup("csv", List(inferSchemaParameter, headerParameter, delimiterParameter, quoteParameter, escapeParameter, multiLineParameter))

  val parameterGroups = List(generalGroup, logGroup)
}