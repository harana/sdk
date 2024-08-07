package com.harana.sdk.shared.models.flow.actiontypes.output

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup, ParameterValue}
import com.harana.sdk.shared.models.data.ConnectionTypes
import com.harana.sdk.shared.models.flow.actiontypes.logGroup

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
  val extendedBsonTypesParameter = Parameter.Boolean("extended-bson-types", Some(ParameterValue.Boolean(true)))
  val localThresholdInMsParameter = Parameter.Integer("local-threshold", Some(ParameterValue.Integer(15)))
  val replaceDocumentParameter = Parameter.Boolean("replace-document", Some(ParameterValue.Boolean(true)))
  val maxBatchSizeParameter = Parameter.Integer("max-batch-size", Some(ParameterValue.Integer(512)))
  val writeConcernParameter = Parameter.String("write-concern", Some(ParameterValue.String("majority")))
  val writeConcernAcknowledgeJournalParameter = Parameter.Boolean("write-concern-acknowledge-journal", Some(ParameterValue.Boolean(true)))
  val writeConcernTimeoutParameter = Parameter.Integer("write-concern-timeout")

  val shardKeyParameter = Parameter.String("shard-key", Some(ParameterValue.String("_id")))
  val forceInsertParameter = Parameter.Boolean("force-insert", Some(ParameterValue.Boolean(false)))
  val orderedParameter = Parameter.Boolean("ordered", Some(ParameterValue.Boolean(true)))

  val parameterGroups = List(ParameterGroup("general", List(dataSourceParameter)), logGroup)

}