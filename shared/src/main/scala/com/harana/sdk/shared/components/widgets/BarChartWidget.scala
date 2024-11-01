package com.harana.sdk.shared.components.widgets

import com.harana.sdk.shared.models.common.Component
import io.circe.{Decoder, Encoder}

case class BarChartWidget(fixme: String) extends Component derives Decoder, Encoder