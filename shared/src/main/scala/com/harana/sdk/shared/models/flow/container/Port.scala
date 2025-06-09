package com.harana.sdk.shared.models.flow.container

import io.circe.{Decoder, Encoder, Json}

case class Port(name: String,
                internal: Option[Int],
                external: Option[Int]) derives Decoder, Encoder