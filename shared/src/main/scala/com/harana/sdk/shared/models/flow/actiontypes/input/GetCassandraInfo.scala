package com.harana.sdk.shared.models.flow.actiontypes.input

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup, ParameterValue}
import com.harana.sdk.shared.models.data.ConnectionTypes
import com.harana.sdk.shared.models.flow.actiontypes.logGroup

class GetCassandraInfo extends InputActionTypeInfo {

  val id = "BF9F07F7-86B9-4578-A9AB-6896864A8139"

  val tags = Set("cassandra")
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
      ("quorum", ParameterValue.String("QUORUM")),
      ("local-quorum", ParameterValue.String("LOCAL_QUORUM")),
      ("one", ParameterValue.String("ONE")),
      ("two", ParameterValue.String("TWO")),
      ("local-one", ParameterValue.String("LOCAL_ONE")),
      ("serial", ParameterValue.String("SERIAL")),
      ("local-serial", ParameterValue.String("LOCAL_SERIAL"))
    ))
  val ttlParameter = Parameter.Long("ttl", placeholder = Some(0))
  val concurrentReadsParameter = Parameter.Long("concurrent-reads")
  val fetchSizeInRowsParameter = Parameter.Long("fetch-size-in-rows")
  val recordMetricsParameter = Parameter.Boolean("record-metrics")
  val maxReadsPerSecParameter = Parameter.Long("max-reads-per-sec")
  val splitSizeInMBParameter = Parameter.Long("split-size-in-mb")
  val throughputMBPerSecParameter = Parameter.Long("throughput-mb-per-sec")

  val directJoinSettingParameter = Parameter.String("direct-join-setting", options =
    List(
      ("on", ParameterValue.String("on")),
      ("off", ParameterValue.String("off")),
      ("auto", ParameterValue.String("auto"))
    ))

  val directJoinSizeRatioParameter = Parameter.Decimal("direct-join-size-ratio")
  val ignoreMissingMetaColumnsParameter = Parameter.Boolean("ignore-missing-meta-columns")

  val advancedGroup = ParameterGroup("general", List(
    consistencyLevelParameter, ttlParameter, concurrentReadsParameter, recordMetricsParameter,
    maxReadsPerSecParameter, splitSizeInMBParameter, throughputMBPerSecParameter, directJoinSettingParameter,
    directJoinSizeRatioParameter, ignoreMissingMetaColumnsParameter
  ))

  val parameterGroups = List(generalGroup, advancedGroup, logGroup)
}