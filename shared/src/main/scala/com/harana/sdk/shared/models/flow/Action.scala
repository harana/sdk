package com.harana.sdk.shared.models.flow

import com.harana.sdk.shared.models.common.Parameter.{ParameterName, ParameterValues}
import com.harana.sdk.shared.models.common.ParameterValue
import com.harana.sdk.shared.models.flow.Action.ActionId
import com.harana.sdk.shared.utils.Random
import io.circe.generic.JsonCodec
import com.harana.sdk.shared.utils.CirceCodecs._

@JsonCodec
case class Action(id: ActionId,
									actionType: ActionTypeInfo,
									position: (Int, Int),
									title: Option[String],
									description: Option[String],
									overrideColor: Option[String],
									parameterValues: Map[ParameterName, ParameterValue])

object Action {
	type ActionId = String

	def apply(actionType: ActionTypeInfo,
						position: (Int, Int),
						title: Option[String],
						description: Option[String],
						overrideColor: Option[String],
						parameterValues: ParameterValues): Action =
		apply(Random.long, actionType, position, title, description, overrideColor, parameterValues.underlying.asInstanceOf[Map[ParameterName, ParameterValue]])
}