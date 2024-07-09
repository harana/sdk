package com.harana.sdk.shared.models.features.chronon

import io.circe.generic.JsonCodec

@JsonCodec
case class Window(length: Int,
                  timeUnit: TimeUnit)