package com.harana.sdk.shared.models.flow.actiontypes.input

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.ConnectionTypes
import com.harana.sdk.shared.models.flow.actiontypes.logGroup

class GetMongoDbInfo extends InputActionTypeInfo {

  val id = "DB2FE265-F548-4A7A-BE55-6644BAF18ED6"

  val tags = Set()
  val dataSourceType = ConnectionTypes.MongoDb

  // General
  val dataSourceParameter = Parameter.Connection("data-source", dataSourceType, required = true)
  val databaseParameter = Parameter.String("database", required = true)
  val collectionParameter = Parameter.String("collection", required = true)
  val generalGroup = ParameterGroup("general", List(dataSourceParameter, databaseParameter, collectionParameter))

  // Advanced
  val batchSizeParameter = Parameter.Integer("batch-size")
  val localThresholdInMsParameter = Parameter.Integer("local-threshold-in-ms", Some(15))
  val readPreferenceParameter = Parameter.String("read-preference", options = List(
    ("primary", "primary"),
    ("primary-preferred", "primaryPreferred"),
    ("secondary", "secondary"),
    ("secondary-preferred", "secondaryPreferred"),
    ("nearest", "nearest"),
  ))
  val readConcernParameter = Parameter.String("read-concern", options = List(
    ("local", "local"),
    ("available", "available"),
    ("majority", "majority"),
    ("linearizable", "linearizable"),
    ("snapshot", "snapshot")
  ))
  val sampleSizeParameter = Parameter.Integer("sample-size", Some(1000))
  val samplePoolSizeParameter = Parameter.Integer("sample-pool-size", Some(10000))
  val advancedGroup = ParameterGroup("advanced", List(batchSizeParameter, localThresholdInMsParameter, readPreferenceParameter, readConcernParameter, sampleSizeParameter, samplePoolSizeParameter))

  val parameterGroups = List(generalGroup, advancedGroup, logGroup)
}