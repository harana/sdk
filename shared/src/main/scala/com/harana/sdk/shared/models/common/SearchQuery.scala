package com.harana.sdk.shared.models.common

import io.circe.{Decoder, Encoder, Json}

case class SearchQuery(query: String) derives Decoder, Encoder