package com.harana.sdk.shared.models.data.datasourcetypes.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.DataSourceType

import scala.scalajs.reflect.annotation.EnableReflectiveInstantiation

@EnableReflectiveInstantiation
class GoogleSpanner extends DataSourceType {

  val instanceIdParameter = Parameter.String("instanceId")
  val generalGroup = ParameterGroup("general", List(instanceIdParameter))

  val parameterGroups = List(generalGroup)
}