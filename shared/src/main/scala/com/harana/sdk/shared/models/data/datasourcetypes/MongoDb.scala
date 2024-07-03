package com.harana.sdk.shared.models.data.datasourcetypes

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.DataSourceType

class MongoDb extends DataSourceType {

  val hostParameter = Parameter.IPAddress("host", required = true, port = true, portDefault = Some(27017))
  val generalGroup = ParameterGroup("general", List(hostParameter))

  val parameterGroups = List(generalGroup)
}