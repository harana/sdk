package com.harana.sdk.shared.components.structure

import com.harana.sdk.shared.models.common.Component
import io.circe.{Decoder, Encoder}

case class AccordionStructure(fixme: String) extends Component derives Decoder, Encoder