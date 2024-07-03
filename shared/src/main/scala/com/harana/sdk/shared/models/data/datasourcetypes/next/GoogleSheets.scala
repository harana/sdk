package com.harana.sdk.shared.models.data.datasourcetypes.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.DataSourceType

import scala.scalajs.reflect.annotation.EnableReflectiveInstantiation

@EnableReflectiveInstantiation
class GoogleSheets extends DataSourceType {

  val serviceAccountIdParameter = Parameter.String("serviceAccountId", required = true)
  val pemPrivateKeyParameter = Parameter.String("pemPrivateKey", multiLine = true)
  val generalGroup = ParameterGroup("general", List(serviceAccountIdParameter, pemPrivateKeyParameter))

  val parameterGroups = List(generalGroup)
}