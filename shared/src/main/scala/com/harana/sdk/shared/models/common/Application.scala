package com.harana.sdk.shared.models.common

import io.circe.{Decoder, Encoder, Json}

case class Application(name: String, version: String) derives Decoder, Encoder