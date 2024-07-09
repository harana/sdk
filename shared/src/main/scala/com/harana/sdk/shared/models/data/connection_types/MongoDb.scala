package com.harana.sdk.shared.models.data.connection_types

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.ConnectionType

class MongoDb extends ConnectionType {

  val id = "AD1FCF71-4B81-41A7-96AC-0E35DBD26DB1"

  val hostParameter = Parameter.IPAddress("host", required = true, port = true, portDefault = Some(27017))
  val generalGroup = ParameterGroup("general", List(hostParameter))

  val parameterGroups = List(generalGroup)

}