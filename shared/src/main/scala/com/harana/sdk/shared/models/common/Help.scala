package com.harana.sdk.shared.models.common

import io.circe.{Decoder, Encoder, Json}

case class HelpCategory(name: String, pages: List[HelpPage]) derives Decoder, Encoder

case class HelpPage(name: String, icon: Option[String], path: String) derives Decoder, Encoder