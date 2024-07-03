package com.harana.sdk.shared.models.flow.actiontypes.input

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup, ParameterValue}
import com.harana.sdk.shared.models.data.DataSourceTypes
import com.harana.sdk.shared.models.flow.actiontypes.logGroup

class GetMongoDbInfo extends InputActionTypeInfo {

  val tags = Set()
  val dataSourceType = DataSourceTypes.MongoDb

  // General
  val dataSourceParameter = Parameter.DataSource("data-source", dataSourceType, required = true)
  val databaseParameter = Parameter.String("database", required = true)
  val collectionParameter = Parameter.String("collection", required = true)
  val generalGroup = ParameterGroup("general", List(dataSourceParameter, databaseParameter, collectionParameter))

  // Advanced
  val batchSizeParameter = Parameter.Integer("batch-size")
  val localThresholdInMsParameter = Parameter.Integer("local-threshold-in-ms", Some(ParameterValue.Integer(15)))
  val readPreferenceParameter = Parameter.String("read-preference", options = List(
    ("primary", ParameterValue.String("primary")),
    ("primary-preferred", ParameterValue.String("primaryPreferred")),
    ("secondary", ParameterValue.String("secondary")),
    ("secondary-preferred", ParameterValue.String("secondaryPreferred")),
    ("nearest", ParameterValue.String("nearest")),
  ))
  val readConcernParameter = Parameter.String("read-concern", options = List(
    ("local", ParameterValue.String("local")),
    ("available", ParameterValue.String("available")),
    ("majority", ParameterValue.String("majority")),
    ("linearizable", ParameterValue.String("linearizable")),
    ("snapshot", ParameterValue.String("snapshot"))
  ))
  val sampleSizeParameter = Parameter.Integer("sample-size", Some(ParameterValue.Integer(1000)))
  val samplePoolSizeParameter = Parameter.Integer("sample-pool-size", Some(ParameterValue.Integer(10000)))
  val advancedGroup = ParameterGroup("advanced", List(batchSizeParameter, localThresholdInMsParameter, readPreferenceParameter, readConcernParameter, sampleSizeParameter, samplePoolSizeParameter))

  val parameterGroups = List(generalGroup, advancedGroup, logGroup)
}