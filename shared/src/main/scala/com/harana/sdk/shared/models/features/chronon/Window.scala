package com.harana.sdk.shared.models.features.chronon

import io.circe.{Decoder, Encoder}

case class Window(length: Int,
                  timeUnit: TimeUnit) derives Decoder, Encoder