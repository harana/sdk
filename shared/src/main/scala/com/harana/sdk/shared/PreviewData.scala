package com.harana.sdk.shared

import io.circe.generic.JsonCodec

@JsonCodec
case class PreviewData(headers: List[String],
                       rows: List[List[String]])