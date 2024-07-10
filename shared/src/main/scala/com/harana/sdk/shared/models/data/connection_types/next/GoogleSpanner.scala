package com.harana.sdk.shared.models.data.connection_types.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.{ConnectionType, SyncDirection}

import scala.scalajs.reflect.annotation.EnableReflectiveInstantiation

@EnableReflectiveInstantiation
class GoogleSpanner extends ConnectionType {

  val id = "0F48893C-480B-4B2D-A19B-7240B3847C5B"

  val instanceIdParameter = Parameter.String("instanceId")
  val generalGroup = ParameterGroup("general", List(instanceIdParameter))

  val parameterGroups = List(generalGroup)
  val syncDirection = SyncDirection.Bidirectional

}