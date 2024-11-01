package com.harana.sdk.shared.models.flow

import com.harana.sdk.shared.models.flow.ActionId
import com.harana.sdk.shared.models.flow.execution.spark.ExecutionStatus
import io.circe.{Decoder, Encoder}

case class ActionExecution(actionId: ActionId,
                           percentage: Int,
                           executionStatus: ExecutionStatus,
                           executionFailure: Option[String]) derives Decoder, Encoder