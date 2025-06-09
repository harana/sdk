package com.harana.sdk.shared.models.flow

import com.harana.sdk.shared.models.common.{ParameterName, ParameterValues}
import com.harana.sdk.shared.models.flow.ActionId
import com.harana.sdk.shared.utils.Random
import com.harana.sdk.shared.utils.CirceCodecs.*
import io.circe.{Decoder, Encoder, Json}
import com.harana.sdk.shared.models.common.ParameterValues.given

type ActionId = String

case class Action(id: ActionId,
									actionType: ActionTypeInfo,
									position: (Int, Int),
									title: Option[String],
									description: Option[String],
									overrideColor: Option[String],
									values: ParameterValues) derives Decoder, Encoder