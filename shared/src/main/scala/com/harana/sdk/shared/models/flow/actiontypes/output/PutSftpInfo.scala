package com.harana.sdk.shared.models.flow.actiontypes.output

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup, ParameterValue}
import com.harana.sdk.shared.models.flow.actiontypes._
import com.harana.sdk.shared.models.data.ConnectionTypes

class PutSftpInfo extends OutputActionTypeInfo {

  val id = "054760D0-C32B-4A86-8813-EC3120D827A3"

  val tags = Set()

  // General
  val dataSourceType = ConnectionTypes.Sftp
  val dataSourceParameter = Parameter.Connection("data-source", dataSourceType, required = true)
  val fileTypeParameter = Parameter.String("file-type", options = List(
    ("avro", ParameterValue.String("avro")),
    ("csv", ParameterValue.String("csv")),
    ("json", ParameterValue.String("json")),
    ("parquet", ParameterValue.String("parquet")),
    ("text", ParameterValue.String("txt"))
  ), required = true)
  val compressionParameter = Parameter.String("compression", options = List(
    ("none", ParameterValue.String("none")),
    ("bzip2", ParameterValue.String("bzip2")),
    ("gzip", ParameterValue.String("gzip")),
    ("lz4", ParameterValue.String("lz4")),
    ("snappy", ParameterValue.String("snappy")),
  ))

  val generalGroup = ParameterGroup("general", List(dataSourceParameter, pathParameter, fileNameParameter, fileTypeParameter, compressionParameter))
  val parameterGroups = List(generalGroup, logGroup)
}