package com.harana.sdk.shared.models.flow

import com.harana.sdk.shared.models.common.{ParameterMap, ParameterName}
import com.harana.sdk.shared.models.flow.ActionId
import com.harana.sdk.shared.utils.Random
import com.harana.sdk.shared.utils.CirceCodecs.*
import io.circe.{Decoder, Encoder}

type ActionId = String

case class Action(id: ActionId,
									actionType: ActionTypeInfo,
									position: (Int, Int),
									title: Option[String],
									description: Option[String],
									overrideColor: Option[String],
									parameterValues: Map[ParameterName, Any]) derives Decoder, Encoder