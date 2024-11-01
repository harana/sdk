package com.harana.sdk.shared.components.widgets

import com.harana.sdk.shared.components.Value
import com.harana.sdk.shared.models.common.Component
import io.circe.{Decoder, Encoder}

case class PieChartWidget(title: String,
            subtitle: String,
            values: List[Value],
            relatedValues: List[Value] = List()) extends Component derives Decoder, Encoder