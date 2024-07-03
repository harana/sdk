package com.harana.sdk.shared.models.data.datasourcetypes.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.DataSourceType

import scala.scalajs.reflect.annotation.EnableReflectiveInstantiation

@EnableReflectiveInstantiation
class BigQuery extends DataSourceType {

  val accountCredentialsParameter = Parameter.String("accountCredentials", multiLine = true, required = true)
  val generalGroup = ParameterGroup("general", List(accountCredentialsParameter))

  val parameterGroups = List(generalGroup)
}