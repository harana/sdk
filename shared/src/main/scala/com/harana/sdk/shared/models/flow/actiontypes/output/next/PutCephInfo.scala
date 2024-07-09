package com.harana.sdk.shared.models.flow.actiontypes.output.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.flow.actiontypes.ActionTypeGroup
import com.harana.sdk.shared.models.data.ConnectionTypes
import com.harana.sdk.shared.models.flow.actiontypes.output.OutputActionTypeInfo

class PutCephInfo extends OutputActionTypeInfo {

  val id = "A63DA2B7-C054-4150-8680-E901BC795956"

  val tags = Set()
  val dataSourceType = ConnectionTypes.Ceph
  val dataSourceParameter = Parameter.Connection("data-source", dataSourceType, required = true)
  val parameterGroups = List(ParameterGroup("general", List(dataSourceParameter)))

}