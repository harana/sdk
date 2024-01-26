package com.harana.sdk.shared.models

import io.circe.generic.JsonCodec

import java.time.Instant

@JsonCodec
case class HaranaFile(name: String,
                      path: String,
                      extension: Option[String],
                      isFolder: Boolean,
                      created: Instant,
                      updated: Instant,
                      size: Long,
                      tags: List[String])