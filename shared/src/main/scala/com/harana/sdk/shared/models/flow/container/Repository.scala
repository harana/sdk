package com.harana.sdk.shared.models.flow.container

import io.circe.{Decoder, Encoder, Json}

case class Repository(name: String,
                      git: Git) derives Decoder, Encoder