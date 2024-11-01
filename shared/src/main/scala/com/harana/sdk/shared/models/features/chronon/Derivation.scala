package com.harana.sdk.shared.models.features.chronon

import io.circe.{Decoder, Encoder}

case class Derivation(name: Option[String] = None,
                      expression: Option[String] = None) derives Decoder, Encoder

