package com.harana.sdk.shared.models.flow.container

import io.circe.{Decoder, Encoder, Json}

case class Docker(image: Option[String],
                  repository: Option[String],
                  path: Option[String]) derives Decoder, Encoder