package com.harana.sdk.shared.models.flow

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup, ParameterGroupLayout, ParameterValue}

package object actiontypes {

  val formatParameter = Parameter.String("format", required = true, options = List(
    ("avro", ParameterValue.String("avro")),
    ("binary-file", ParameterValue.String("binaryFile")),
    ("csv", ParameterValue.String("csv")),
    ("image", ParameterValue.String("image")),
    ("json", ParameterValue.String("json")),
    ("libsvm", ParameterValue.String("libsvm")),
    ("orc", ParameterValue.String("orc")),
    ("parquet", ParameterValue.String("parquet")),
    ("text", ParameterValue.String("text"))
  ))

  val pathParameter = Parameter.String("path", multiLine = true)
  val fileNameParameter = Parameter.String("fileName", required = true)

  val profileParameter = Parameter.Boolean("profile")
  val sampleParameter = Parameter.Boolean("sample")
  val schemaParameter = Parameter.Boolean("schema")

  def logGroup = ParameterGroup("log", List(profileParameter, sampleParameter, schemaParameter), ParameterGroupLayout.Grid)
}