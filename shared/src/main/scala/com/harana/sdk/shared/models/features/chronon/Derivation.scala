package com.harana.sdk.shared.models.features.chronon

import io.circe.generic.JsonCodec

@JsonCodec
case class Derivation(name: Option[String] = None,
                      expression: Option[String] = None)

