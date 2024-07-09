package com.harana.sdk.shared.models.flow

import com.harana.sdk.shared.models.common.ParameterGroup
import com.harana.sdk.shared.models.flow.actiontypes.ActionTypeGroup

trait ActionTypeInfo {
  val id: ActionTypeInfo.Id
  val tags: Set[String]
  val group: ActionTypeGroup
  val inputPorts: List[Port]
  val outputPorts: List[Port]
  val parameterGroups: List[ParameterGroup]
  val mode: ActionMode = ActionMode.Normal
}

object ActionTypeInfo {
  type Id = String
}