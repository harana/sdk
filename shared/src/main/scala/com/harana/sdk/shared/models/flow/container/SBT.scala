package com.harana.sdk.shared.models.flow.container

import io.circe.{Decoder, Encoder, Json}

case class SBT(memory: Option[String]) derives Decoder, Encoder
