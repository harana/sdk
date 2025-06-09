package com.harana.sdk.shared.models.features.chronon

import io.circe.{Decoder, Encoder, Json}

case class Derivation(name: Option[String] = None,
                      expression: Option[String] = None) derives Decoder, Encoder

