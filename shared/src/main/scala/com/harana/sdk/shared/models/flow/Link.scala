package com.harana.sdk.shared.models.flow

import com.harana.sdk.shared.models.flow.Action.ActionId
import io.circe.generic.JsonCodec
import com.harana.sdk.shared.utils.CirceCodecs._

@JsonCodec
case class Link(fromAction: ActionId,
                fromPort: Port,
                toAction: ActionId,
                toPort: Port)