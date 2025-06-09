package com.harana.sdk.shared.models.features.chronon

import io.circe.{Decoder, Encoder, Json}

case class ExternalPart(source: Option[ExternalSource] = None,
                        keyMapping: Option[Map[String, String]] = None,
                        prefix: Option[String] = None) derives Decoder, Encoder
