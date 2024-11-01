package com.harana.sdk.shared.models.flow.execution.spark

import io.circe.{Decoder, Encoder}
import java.time.Instant

case class ExecutorTimespan(executorId: String,
                            hostId: String,
                            startTime: Instant,
                            endTime: Instant,
                            cores: Int,
                            metrics: AggregateMetrics) derives Decoder, Encoder