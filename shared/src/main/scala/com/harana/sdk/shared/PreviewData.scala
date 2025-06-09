package com.harana.sdk.shared

import io.circe.{Decoder, Encoder, Json}

case class PreviewData(headers: List[String],
                       rows: List[List[String]]) derives Decoder, Encoder