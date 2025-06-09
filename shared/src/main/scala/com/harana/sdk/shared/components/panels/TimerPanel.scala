package com.harana.sdk.shared.components.panels

import com.harana.sdk.shared.models.common.Component
import io.circe.{Decoder, Encoder, Json}

case class TimerPanel(fixme: String) extends Component derives Decoder, Encoder