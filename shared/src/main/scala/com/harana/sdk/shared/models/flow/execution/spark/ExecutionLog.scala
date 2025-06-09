package com.harana.sdk.shared.models.flow.execution.spark

import io.circe.{Decoder, Encoder, Json}

import java.time.Instant

case class ExecutionLog(level: String,
                        message: String,
                        timestamp: Instant) derives Decoder, Encoder