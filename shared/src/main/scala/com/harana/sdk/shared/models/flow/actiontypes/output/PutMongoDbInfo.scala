package com.harana.sdk.shared.models.flow.actiontypes.output

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.ConnectionTypes
import com.harana.sdk.shared.models.flow.actiontypes.logGroup
import com.harana.sdk.shared.models.common.ParameterValue.given

class PutMongoDbInfo extends OutputActionTypeInfo {

  val id = "F109ADA4-1063-4EEA-B24A-C9AC2E221984"

  val tags = Set()
  val dataSourceType = ConnectionTypes.MongoDb

  // General
  val dataSourceParameter = Parameter.Connection("data-source", dataSourceType, required = true)
  val databaseParameter = Parameter.String("database", required = true)
  val collectionParameter = Parameter.String("collection", required = true)
  val generalGroup = ParameterGroup("general", List(dataSourceParameter, databaseParameter, collectionParameter))

  // Advanced
  val extendedBsonTypesParameter = Parameter.Boolean("extended-bson-types", true)
  val localThresholdInMsParameter = Parameter.Integer("local-threshold", 15)
  val replaceDocumentParameter = Parameter.Boolean("replace-document", true)
  val maxBatchSizeParameter = Parameter.Integer("max-batch-size", 512)
  val writeConcernParameter = Parameter.String("write-concern", "majority")
  val writeConcernAcknowledgeJournalParameter = Parameter.Boolean("write-concern-acknowledge-journal", true)
  val writeConcernTimeoutParameter = Parameter.Integer("write-concern-timeout")

  val shardKeyParameter = Parameter.String("shard-key", "_id")
  val forceInsertParameter = Parameter.Boolean("force-insert")
  val orderedParameter = Parameter.Boolean("ordered", true)

  val parameterGroups = List(ParameterGroup("general", List(dataSourceParameter)), logGroup)

}