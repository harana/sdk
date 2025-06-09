package com.harana.sdk.shared.models

import java.time.Instant
import io.circe.{Decoder, Encoder, Json}

case class HaranaFile(name: String,
                      path: String,
                      extension: Option[String],
                      isFolder: Boolean,
                      created: Instant,
                      updated: Instant,
                      size: Long,
                      tags: List[String]) derives Decoder, Encoder