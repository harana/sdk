package com.harana.sdk.shared.models.flow.actiontypes.input

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.DataSourceTypes
import com.harana.sdk.shared.models.flow.actiontypes._

class GetS3Info extends InputActionTypeInfo {

  val tags = Set("aws")
  val dataSourceType = DataSourceTypes.S3
  val dataSourceParameter = Parameter.DataSource("data-source", dataSourceType, required = true)

  val parameterGroups = List(ParameterGroup("general", List(dataSourceParameter, pathParameter, fileNameParameter, formatParameter)), logGroup)

}