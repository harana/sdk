package com.harana.sdk.shared.models.flow.container

import io.circe.{Decoder, Encoder, Json}

case class Python(repository: Option[String],
                  path: Option[String],
                  file: Option[String],
                  baseImage: Option[String]) derives Decoder, Encoder