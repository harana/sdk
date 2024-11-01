package com.harana.sdk.shared.models.flow.execution.spark

import io.circe.{Decoder, Encoder}

import java.time.Instant

case class ApplicationInfo(applicationId: String,
                           startTime: Instant,
                           endTime: Instant) derives Decoder, Encoder