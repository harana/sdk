package com.harana.sdk.shared.models.flow.actiontypes.input

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.DataSourceTypes
import com.harana.sdk.shared.models.flow.actiontypes._

class GetHaranaFilesInfo extends InputActionTypeInfo {

  val tags = Set("harana")
  val dataSourceType = DataSourceTypes.HaranaFiles
  val dataSourceParameter = Parameter.DataSource("data-source", dataSourceType, required = true)

  val parameterGroups = List(ParameterGroup("general", List(pathParameter, fileNameParameter, formatParameter)), logGroup)

}