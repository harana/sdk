package com.harana.sdk.shared.models.flow.actiontypes.output.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup, ParameterValue}
import com.harana.sdk.shared.models.flow.actiontypes.ActionTypeGroup
import com.harana.sdk.shared.models.data.ConnectionTypes
import com.harana.sdk.shared.models.flow.actiontypes.output.OutputActionTypeInfo

class PutBigQueryInfo extends OutputActionTypeInfo {

  val tags = Set()
  val dataSourceType = ConnectionTypes.BigQuery

  val dataSourceParameter = Parameter.Connection("data-source", dataSourceType, required = true)
  val datasetParameter = Parameter.String("dataset", required = true)
  val tableParameter = Parameter.String("table", required = true)
  val projectParameter = Parameter.String("project")

  val parentProjectParameter = Parameter.String("parentProject")
  val maxParallelismParameter = Parameter.Long("maxParallelism")
  val viewsEnabledParameter = Parameter.Boolean("viewsEnabled")
  val materializationProjectParameter = Parameter.String("materializationProject")
  val readDataFormatParameter = Parameter.String("readDataFormat", options = List(
    ("arrow", ParameterValue.String("arrow")),
    ("avro", ParameterValue.String("avro"))
  ))
  val optimizedEmptyProjectionParameter = Parameter.Boolean("optimizedEmptyProjection")
  val createDispositionParameter = Parameter.String("createDisposition", options = List(
    ("createIfNeeded", ParameterValue.String("createIfNeeded")),
    ("createNever", ParameterValue.String("createNever"))
  ))
  val persistentGcsBucketParameter = Parameter.String("persistentGcsBucket")
  val persistentGcsPathParameter = Parameter.String("persistentGcsPath")
  val intermediateFormatParameter = Parameter.String("intermediateFormat", options = List(
    ("parquet", ParameterValue.String("parquet")),
    ("orc", ParameterValue.String("orc")),
    ("avro", ParameterValue.String("avro"))
  ))
  val datePartitionParameter = Parameter.String("datePartition")
  val partitionFieldParameter = Parameter.String("partitionField")
  val clusteredFieldsParameter = Parameter.StringList("clusteredFields")
  val allowFieldAdditionParameter = Parameter.Boolean("allowFieldAddition")
  val allowFieldRelaxationParameter = Parameter.Boolean("allowFieldRelaxation")

  val defaultGroup = ParameterGroup("general", List(
    dataSourceParameter, datasetParameter, tableParameter, projectParameter
  ))

  val advancedGroup = ParameterGroup("advanced", List(
    parentProjectParameter, maxParallelismParameter, viewsEnabledParameter, materializationProjectParameter, readDataFormatParameter, optimizedEmptyProjectionParameter, createDispositionParameter, persistentGcsBucketParameter, persistentGcsPathParameter, intermediateFormatParameter, datePartitionParameter, partitionFieldParameter, clusteredFieldsParameter, allowFieldAdditionParameter, allowFieldRelaxationParameter
  ))

  val parameterGroups = List(defaultGroup, advancedGroup)
}