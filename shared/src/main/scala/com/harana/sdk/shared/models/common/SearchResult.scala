package com.harana.sdk.shared.models.common

import io.circe.{Decoder, Encoder, Json}

case class SearchResult[T <: Entity](entities: List[T],
                                     referredEntities: Map[String, T],
                                     scores: List[Double]) derives Decoder, Encoder