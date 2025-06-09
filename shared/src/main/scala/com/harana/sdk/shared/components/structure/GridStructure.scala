package com.harana.sdk.shared.components.structure

import com.harana.sdk.shared.models.common.Component
import io.circe.{Decoder, Encoder, Json}

case class GridStructure(fixme: String) extends Component derives Decoder, Encoder