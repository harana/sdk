package com.harana.sdk.shared.models.terminals

import java.time.Instant
import io.circe.{Decoder, Encoder, Json}

case class TerminalHistory(message: String, created: Instant = Instant.now) derives Decoder, Encoder