package com.harana.sdk.shared.models.flow.actiontypes.input

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.ConnectionTypes
import com.harana.sdk.shared.models.flow.actiontypes._

class GetS3Info extends InputActionTypeInfo {

  val id = "508C6B9B-3662-468C-A124-79AC28D854E1"

  val tags = Set("aws")
  val dataSourceType = ConnectionTypes.S3
  val dataSourceParameter = Parameter.Connection("data-source", dataSourceType, required = true)

  val parameterGroups = List(ParameterGroup("general", List(dataSourceParameter, pathParameter, fileNameParameter, formatParameter)), logGroup)

}