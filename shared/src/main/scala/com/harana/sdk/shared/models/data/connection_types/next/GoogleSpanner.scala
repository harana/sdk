package com.harana.sdk.shared.models.data.connection_types.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.ConnectionType

import scala.scalajs.reflect.annotation.EnableReflectiveInstantiation

@EnableReflectiveInstantiation
class GoogleSpanner extends ConnectionType {

  val instanceIdParameter = Parameter.String("instanceId")
  val generalGroup = ParameterGroup("general", List(instanceIdParameter))

  val parameterGroups = List(generalGroup)
}