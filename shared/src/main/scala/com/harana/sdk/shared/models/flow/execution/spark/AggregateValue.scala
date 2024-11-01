package com.harana.sdk.shared.models.flow.execution.spark

import io.circe.{Decoder, Encoder}

case class AggregateValue(value: Long,
                          min: Long,
                          max: Long,
                          mean: Double,
                          variance: Double,
                          m2: Double) derives Decoder, Encoder