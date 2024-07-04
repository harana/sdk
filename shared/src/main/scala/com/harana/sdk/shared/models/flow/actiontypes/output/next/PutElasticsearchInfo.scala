package com.harana.sdk.shared.models.flow.actiontypes.output.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup, ParameterValue}
import com.harana.sdk.shared.models.data.ConnectionTypes
import com.harana.sdk.shared.models.flow.actiontypes._
import com.harana.sdk.shared.models.flow.actiontypes.output.OutputActionTypeInfo

class PutElasticsearchInfo extends OutputActionTypeInfo {

  val tags = Set()
  val dataSourceType = ConnectionTypes.Elasticsearch

  // General
  val dataSourceParameter = Parameter.Connection("data-source", dataSourceType, required = true)
  val generalGroup = ParameterGroup("general", List(dataSourceParameter, pathParameter))

  val writeOperationParameter = Parameter.String("write-operation", required = true, options =
    List(
      ("index", ParameterValue.String("index")),
      ("create", ParameterValue.String("create")),
      ("update", ParameterValue.String("update")),
      ("upsert", ParameterValue.String("upsert"))
    ))

  val mappingIdParameter = Parameter.String("mapping-id")
  val mappingExcludeParameter = Parameter.String("mapping-exclude")
  val mappingIncludeParameter = Parameter.String("mapping-include")
  val mappingJoinParameter = Parameter.String("mapping-join")
  val mappingParentParameter = Parameter.String("mapping-parent")
  val mappingRoutingParameter = Parameter.String("mapping-routing")
  val mappingTimestampParameter = Parameter.String("mapping-timestamp")
  val mappingVersionParameter = Parameter.String("mapping-version")
  val mappingVersionTypeParameter = Parameter.String("mapping-version-type")

  val mappingGroup = ParameterGroup("mapping", List(
    mappingIdParameter, mappingExcludeParameter, mappingIncludeParameter, mappingJoinParameter, mappingParentParameter,
    mappingRoutingParameter, mappingTimestampParameter, mappingVersionParameter, mappingVersionTypeParameter))

  val parameterGroups = List(generalGroup, mappingGroup, logGroup)

}
