package com.harana.sdk.shared.models.data.connection_types.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.ConnectionType

import scala.scalajs.reflect.annotation.EnableReflectiveInstantiation

@EnableReflectiveInstantiation
class GoogleSheets extends ConnectionType {

  val id = "4AD7C351-61E1-44FB-9C70-49B1F2EF4FB3"

  val serviceAccountIdParameter = Parameter.String("serviceAccountId", required = true)
  val pemPrivateKeyParameter = Parameter.String("pemPrivateKey", multiLine = true)
  val generalGroup = ParameterGroup("general", List(serviceAccountIdParameter, pemPrivateKeyParameter))

  val parameterGroups = List(generalGroup)

}