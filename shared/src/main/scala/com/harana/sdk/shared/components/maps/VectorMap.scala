package com.harana.sdk.shared.components.maps

import com.harana.sdk.shared.models.common.Component
import io.circe.{Decoder, Encoder, Json}

case class VectorMap(fixme: String) extends Component derives Decoder, Encoder