package com.harana.sdk.shared.models.data.connection_types.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.{ConnectionType, SyncDirection}

import scala.scalajs.reflect.annotation.EnableReflectiveInstantiation

@EnableReflectiveInstantiation
class BigQuery extends ConnectionType {

  val id = "E46DC4F8-5614-4930-9099-6FA4950BF867"

  val accountCredentialsParameter = Parameter.String("accountCredentials", multiLine = true, required = true)
  val generalGroup = ParameterGroup("general", List(accountCredentialsParameter))

  val parameterGroups = List(generalGroup)
  val syncDirection = SyncDirection.Bidirectional
}