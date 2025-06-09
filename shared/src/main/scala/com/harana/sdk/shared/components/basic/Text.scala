package com.harana.sdk.shared.components.basic

import com.harana.sdk.shared.models.common.Component
import io.circe.{Decoder, Encoder, Json}

case class Text(value: String) extends Component derives Decoder, Encoder