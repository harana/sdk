package com.harana.sdk.shared.models.flow.execution.spark

import io.circe.{Decoder, Encoder, Json}

import java.time.Instant

case class JobTimespan(jobId: String,
                       startTime: Instant,
                       endTime: Instant,
                       metrics: AggregateMetrics,
                       stageMap: Map[Int, StageTimespan]) derives Decoder, Encoder