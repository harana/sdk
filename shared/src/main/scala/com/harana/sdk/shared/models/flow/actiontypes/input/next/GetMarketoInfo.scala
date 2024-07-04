package com.harana.sdk.shared.models.flow.actiontypes.input.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.ConnectionTypes
import com.harana.sdk.shared.models.flow.actiontypes.input.InputActionTypeInfo

class GetMarketoInfo extends InputActionTypeInfo {

  val tags = Set()
  val dataSourceType = ConnectionTypes.Marketo

  // General
  val dataSourceParameter = Parameter.Connection("data-source", dataSourceType, required = true)
  val objectParameter = Parameter.String("object")
  val generalGroup = ParameterGroup("general", List(dataSourceParameter, objectParameter))

  // Query
  val filterKeyParameter = Parameter.String("filterKey")
  val filterValuesParameter = Parameter.StringList("filterValues")
  val sinceDateTimeParameter = Parameter.String("sinceDateTime")
  val queryGroup = ParameterGroup("query", List(filterKeyParameter, filterValuesParameter, sinceDateTimeParameter))

  val parameterGroups = List(generalGroup, queryGroup)
}