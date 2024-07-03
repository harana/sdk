package com.harana.sdk.shared.models.flow.actiontypes.output

import com.harana.sdk.shared.models.common.Parameter
import com.harana.sdk.shared.models.flow.actiontypes.ActionTypeGroup
import com.harana.sdk.shared.models.flow.{ActionTypeInfo, Port}

abstract class OutputActionTypeInfo extends ActionTypeInfo {
  val group = ActionTypeGroup.Output
  val inputPorts = List(Port.DataFrame("in"))
  val outputPorts = List()

  val saveModeParameter = Parameter.String("save-mode", required = true, options = List(
    ("overwrite", "overwrite"),
    ("append", "append"),
    ("error-if-exists", "errorIfExists"),
    ("ignore", "ignore")
  ))
}