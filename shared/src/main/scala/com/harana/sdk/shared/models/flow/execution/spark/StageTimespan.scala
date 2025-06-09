package com.harana.sdk.shared.models.flow.execution.spark

import io.circe.{Decoder, Encoder, Json}

import java.time.Instant

case class StageTimespan(stageId: Int,
                         startTime: Instant,
                         endTime: Instant,
                         numberOfTasks: Long,
                         metrics: AggregateMetrics,
                         minTaskLaunchTime: Instant,
                         maxTaskFinishTime: Instant,
                         parentStageIds: List[Int],
                         taskExecutionTimes: List[Int],
                         taskPeakMemoryUsage: List[Long]) derives Decoder, Encoder