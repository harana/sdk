package com.harana.sdk.shared.models.common

import io.circe.{Decoder, Encoder, Json}

case class Error(userMessage: Option[String], retriable: Boolean = false) extends Serializable derives Decoder, Encoder