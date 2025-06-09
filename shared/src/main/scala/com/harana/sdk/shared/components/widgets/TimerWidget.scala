package com.harana.sdk.shared.components.widgets

import com.harana.sdk.shared.models.common.Component
import io.circe.{Decoder, Encoder, Json}

case class TimerWidget(fixme: String) extends Component derives Decoder, Encoder