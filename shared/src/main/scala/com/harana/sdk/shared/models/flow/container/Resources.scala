package com.harana.sdk.shared.models.flow.container

import io.circe.{Decoder, Encoder, Json}

case class Resources(cpu: Option[String],
                     memory: Option[String]) derives Decoder, Encoder