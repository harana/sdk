package com.harana.sdk.shared.models.flow.actiontypes.output

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup, ParameterValue}
import com.harana.sdk.shared.models.flow.actiontypes.{ActionTypeGroup, logGroup}
import com.harana.sdk.shared.models.data.ConnectionTypes

class PutCassandraInfo extends OutputActionTypeInfo {

  val tags = Set()
  val dataSourceType = ConnectionTypes.Cassandra

  // General
  val dataSourceParameter = Parameter.Connection("data-source", dataSourceType, required = true)
  val keyspaceParameter = Parameter.String("keyspace", required = true)
  val tableParameter = Parameter.String("table", required = true)
  val generalGroup = ParameterGroup("general", List(dataSourceParameter, keyspaceParameter, tableParameter))

  // Advanced
  val consistencyLevelParameter = Parameter.String("consistency-level", options =
    List(
      ("all", ParameterValue.String("ALL")),
      ("each-quorum", ParameterValue.String("EACH_QUORUM")),
      ("quorum", ParameterValue.String("QUORUM")),
      ("local-quorum", ParameterValue.String("LOCAL_QUORUM")),
      ("one", ParameterValue.String("ONE")),
      ("two", ParameterValue.String("TWO")),
      ("local-one", ParameterValue.String("LOCAL_ONE")),
      ("any", ParameterValue.String("ANY"))
    ))
  val ttlParameter = Parameter.Long("ttl", placeholder = Some(0))
  val concurrentWritesParameter = Parameter.Long("concurrent-writes", placeholder = Some(5))
  val ignoreNullsParameter = Parameter.Boolean("ignore-nulls")
  val timestampParameter = Parameter.Long("timestamp", placeholder = Some(0))
  val batchGroupingBufferSizeParameter = Parameter.Long("batch-grouping-buffer-size", placeholder = Some(1000))
  val batchGroupingKeyParameter = Parameter.String("batch-grouping-key", options =
    List(
      ("none", ParameterValue.String("none")),
      ("replica-set", ParameterValue.String("replica_set")),
      ("partition", ParameterValue.String("partition"))
    ))

  val batchSizeBytesParameter = Parameter.Long("batch-size-bytes", placeholder = Some(1024))
  val batchSizeRowsParameter = Parameter.Long("batch-size-rows")
  val throughputMBPerSecParameter = Parameter.Long("throughput-mb-per-sec")
  val directJoinSettingParameter = Parameter.String("direct-join-setting", options =
    List(
      ("on", ParameterValue.String("on")),
      ("off", ParameterValue.String("off")),
      ("auto", ParameterValue.String("auto"))
    ))
  val directJoinSizeRatioParameter = Parameter.Decimal("direct-join-size-ratio")
  val ignoreMissingMetaColumnsParameter = Parameter.Boolean("ignore-missing-meta-columns")

  val advancedGroup = ParameterGroup("advanced", List(
    consistencyLevelParameter, ttlParameter, concurrentWritesParameter, ignoreNullsParameter,
    timestampParameter, batchGroupingBufferSizeParameter, batchGroupingKeyParameter, batchSizeBytesParameter, throughputMBPerSecParameter,
    directJoinSettingParameter, directJoinSizeRatioParameter, ignoreMissingMetaColumnsParameter
  ))

  val parameterGroups = List(generalGroup, advancedGroup, logGroup)
}