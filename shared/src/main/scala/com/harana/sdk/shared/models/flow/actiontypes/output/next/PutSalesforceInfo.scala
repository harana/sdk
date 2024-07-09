package com.harana.sdk.shared.models.flow.actiontypes.output.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup, ParameterValue}
import com.harana.sdk.shared.models.data.ConnectionTypes
import com.harana.sdk.shared.models.flow.actiontypes.output.OutputActionTypeInfo

class PutSalesforceInfo extends OutputActionTypeInfo {

  val id = "7CBE4AE9-6D8A-4E75-BFC5-BBF451537C3A"

  val tags = Set()

  // General
  val dataSourceType = ConnectionTypes.Salesforce
  val dataSourceParameter = Parameter.Connection("data-source", dataSourceType, required = true)
  val modeParameter = Parameter.String("mode", options = List(
    ("createDataset", ParameterValue.String("createDataset")),
    ("updateObject", ParameterValue.String("updateObject"))
  ), required = true)
  val datasetParameter = Parameter.String("dataset")
  val objectParameter = Parameter.String("object")
  val generalGroup = ParameterGroup("general", List(dataSourceParameter, datasetParameter, objectParameter))

  val parameterGroups = List(generalGroup)

}