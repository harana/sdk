package com.harana.sdk.shared.models.flow

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup, ParameterGroupLayout}

package object actiontypes {

  val formatParameter = Parameter.String("format", required = true, options = List(
    ("avro", "avro"),
    ("binary-file", "binaryFile"),
    ("csv", "csv"),
    ("image", "image"),
    ("json", "json"),
    ("libsvm", "libsvm"),
    ("orc", "orc"),
    ("parquet", "parquet"),
    ("text", "text")
  ))

  val pathParameter = Parameter.String("path", multiLine = true)
  val fileNameParameter = Parameter.String("fileName", required = true)

  val profileParameter = Parameter.Boolean("profile")
  val sampleParameter = Parameter.Boolean("sample")
  val schemaParameter = Parameter.Boolean("schema")

  def logGroup = ParameterGroup("log", List(profileParameter, sampleParameter, schemaParameter), ParameterGroupLayout.Grid)
}