package com.harana.sdk.shared.models.common



case class SearchResult[T <: Entity](entities: List[T],
                                     referredEntities: Map[String, T],
                                     scores: List[Double])