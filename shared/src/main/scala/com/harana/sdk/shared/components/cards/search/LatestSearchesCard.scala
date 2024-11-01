package com.harana.sdk.shared.components.cards.search

import com.harana.sdk.shared.models.common.Component
import io.circe.{Decoder, Encoder}

case class LatestSearchesCard(latestSearches: List[LatestSearch] = List()) extends Component derives Decoder, Encoder

case class LatestSearch(title: String, subtitle: String) derives Decoder, Encoder