package com.harana.sdk.shared.models.flow.actiontypes.output

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.flow.actiontypes._
import com.harana.sdk.shared.models.data.ConnectionTypes

class PutSftpInfo extends OutputActionTypeInfo {

  val id = "054760D0-C32B-4A86-8813-EC3120D827A3"

  val tags = Set()

  // General
  val dataSourceType = ConnectionTypes.Sftp
  val dataSourceParameter = Parameter.Connection("data-source", dataSourceType, required = true)
  val fileTypeParameter = Parameter.String("file-type", options = List(
    ("avro", "avro"),
    ("csv", "csv"),
    ("json", "json"),
    ("parquet", "parquet"),
    ("text", "txt")
  ), required = true)
  val compressionParameter = Parameter.String("compression", options = List(
    ("none", "none"),
    ("bzip2", "bzip2"),
    ("gzip", "gzip"),
    ("lz4", "lz4"),
    ("snappy", "snappy"),
  ))

  val generalGroup = ParameterGroup("general", List(dataSourceParameter, pathParameter, fileNameParameter, fileTypeParameter, compressionParameter))
  val parameterGroups = List(generalGroup, logGroup)
}