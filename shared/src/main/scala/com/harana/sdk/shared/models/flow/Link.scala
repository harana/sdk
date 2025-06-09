package com.harana.sdk.shared.models.flow

import com.harana.sdk.shared.models.flow.ActionId
import com.harana.sdk.shared.utils.CirceCodecs.*
import io.circe.{Decoder, Encoder, Json}

case class Link(fromAction: ActionId,
                fromPort: Port,
                toAction: ActionId,
                toPort: Port) derives Decoder, Encoder