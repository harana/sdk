package com.harana.sdk.shared.models.flow.actiontypes.output.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.flow.actiontypes.ActionTypeGroup
import com.harana.sdk.shared.models.data.DataSourceTypes
import com.harana.sdk.shared.models.flow.actiontypes.output.OutputActionTypeInfo

class PutSalesforceInfo extends OutputActionTypeInfo {

  val tags = Set()

  // General
  val dataSourceType = DataSourceTypes.Salesforce
  val dataSourceParameter = Parameter.DataSource("data-source", dataSourceType, required = true)
  val modeParameter = Parameter.String("mode", options = List(
    ("createDataset", "createDataset"),
    ("updateObject", "updateObject")
  ), required = true)
  val datasetParameter = Parameter.String("dataset")
  val objectParameter = Parameter.String("object")
  val generalGroup = ParameterGroup("general", List(dataSourceParameter, datasetParameter, objectParameter))

  val parameterGroups = List(generalGroup)

}