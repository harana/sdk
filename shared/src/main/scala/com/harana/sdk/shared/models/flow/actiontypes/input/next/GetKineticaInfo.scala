package com.harana.sdk.shared.models.flow.actiontypes.input.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.ConnectionTypes
import com.harana.sdk.shared.models.flow.actiontypes.input.InputActionTypeInfo
//import com.harana.sdk.shared.models.common.ParameterValue.given

class GetKineticaInfo extends InputActionTypeInfo {

  val id = "C2490CEB-62C1-4CDA-AB49-1AAC0F239BC2"

  val tags = Set()
  val dataSourceType = ConnectionTypes.Kinetica

  // General
  val dataSourceParameter = Parameter.Connection("data-source", dataSourceType, required = true)
  val schemaParameter = Parameter.String("schema", required = true)
  val tableParameter = Parameter.String("table", required = true)
  val generalGroup = ParameterGroup("general", List(dataSourceParameter, schemaParameter, tableParameter))

  // Advanced
  val initialOffsetParameter = Parameter.Long("initialOffset")
  val maximumResultsParameter = Parameter.Long("maximumResults", default = -1)
  val partitionsParameter = Parameter.Long("partitions", default = 4)
  val appendNewColumnsParameter = Parameter.Boolean("appendNewColumns")
  val mapColumnsByNameParameter = Parameter.Boolean("mapColumnsByName")
  val advancedGroup = ParameterGroup("advanced", List(initialOffsetParameter, maximumResultsParameter, partitionsParameter, appendNewColumnsParameter, mapColumnsByNameParameter))

  val parameterGroups = List(generalGroup, advancedGroup)

}