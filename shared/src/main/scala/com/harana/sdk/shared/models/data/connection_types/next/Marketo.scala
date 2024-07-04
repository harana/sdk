package com.harana.sdk.shared.models.data.connection_types.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.ConnectionType

import scala.scalajs.reflect.annotation.EnableReflectiveInstantiation

@EnableReflectiveInstantiation
class Marketo extends ConnectionType {

  // General
  val instanceUrlParameter = Parameter.Uri("instanceUrl", required = true)
  val clientIdParameter = Parameter.String("clientId", required = true)
  val clientSecretParameter = Parameter.String("clientSecret", required = true)
  val generalGroup = ParameterGroup("general", List(instanceUrlParameter, clientIdParameter, clientSecretParameter))

  val parameterGroups = List(generalGroup)
}