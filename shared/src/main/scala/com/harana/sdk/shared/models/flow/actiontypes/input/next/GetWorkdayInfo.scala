package com.harana.sdk.shared.models.flow.actiontypes.input.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.{ConnectionType, ConnectionTypes}
import com.harana.sdk.shared.models.flow.actiontypes.input.InputActionTypeInfo

class GetWorkdayInfo extends InputActionTypeInfo {

  val id = "4ADD93B9-C9D0-4E41-9394-172B4EFB13FC"

  val tags = Set()

  // General
  val dataSourceType = ConnectionTypes.Workday
  val dataSourceParameter = Parameter.Connection("data-source", dataSourceType, required = true)
  val requestParameter = Parameter.String("request")
  val objectTagPathParameter = Parameter.String("objectTagPath")
  val detailsTagPathParameter = Parameter.String("detailsTagPath")
  val xpathMapParameter = Parameter.String("xpathMap")
  val namespacePrefixMapParameter = Parameter.String("namespacePrefix")
  val generalGroup = ParameterGroup("general", List(dataSourceParameter, requestParameter, objectTagPathParameter, detailsTagPathParameter, xpathMapParameter, namespacePrefixMapParameter ))

  val parameterGroups = List(generalGroup)
}