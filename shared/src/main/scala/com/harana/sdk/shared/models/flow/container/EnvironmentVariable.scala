package com.harana.sdk.shared.models.flow.container

import io.circe.{Decoder, Encoder, Json}

case class EnvironmentVariable(name: String, value: String) derives Decoder, Encoder