package com.harana.sdk.shared.models.flow.execution.spark

import io.circe.{Decoder, Encoder}

import java.time.Instant

case class HostTimespan(hostId: String,
                        startTime: Instant,
                        endTime: Instant,
                        metrics: AggregateMetrics) derives Decoder, Encoder