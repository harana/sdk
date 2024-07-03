package com.harana.sdk.shared.models.data.datasourcetypes.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.DataSourceType

import scala.scalajs.reflect.annotation.EnableReflectiveInstantiation

@EnableReflectiveInstantiation
class GoogleAnalytics extends DataSourceType {

  val serviceAccountIdParameter = Parameter.String("serviceAccountId", required = true)
  val pemPrivateKeyParameter = Parameter.String("pemPrivateKey", multiLine = true)
  val clientIdParameter = Parameter.String("clientId")
  val clientSecretParameter = Parameter.String("clientSecret")
  val refreshTokenParameter = Parameter.String("refreshToken")
  val generalGroup = ParameterGroup("general", List(serviceAccountIdParameter, pemPrivateKeyParameter, clientIdParameter, clientSecretParameter, refreshTokenParameter))

  val parameterGroups = List(generalGroup)
}