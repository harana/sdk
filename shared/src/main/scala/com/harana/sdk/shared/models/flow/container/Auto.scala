package com.harana.sdk.shared.models.flow.container

import io.circe.{Decoder, Encoder, Json}

case class Auto(repository: Option[String],
                path: Option[String],
                builder: Option[String]) derives Decoder, Encoder