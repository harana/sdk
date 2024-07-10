package com.harana.sdk.shared.models.data.connection_types.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.{ConnectionType, SyncDirection}

import scala.scalajs.reflect.annotation.EnableReflectiveInstantiation

@EnableReflectiveInstantiation
class GoogleAnalytics extends ConnectionType {

  val id = "86CF8517-BEEE-4622-A765-6DF88C6E2C30"

  val serviceAccountIdParameter = Parameter.String("serviceAccountId", required = true)
  val pemPrivateKeyParameter = Parameter.String("pemPrivateKey", multiLine = true)
  val clientIdParameter = Parameter.String("clientId")
  val clientSecretParameter = Parameter.String("clientSecret")
  val refreshTokenParameter = Parameter.String("refreshToken")
  val generalGroup = ParameterGroup("general", List(serviceAccountIdParameter, pemPrivateKeyParameter, clientIdParameter, clientSecretParameter, refreshTokenParameter))

  val parameterGroups = List(generalGroup)
  val syncDirection = SyncDirection.Bidirectional

}