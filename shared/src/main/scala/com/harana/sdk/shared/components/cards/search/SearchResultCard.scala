package com.harana.sdk.shared.components.cards.search

import com.harana.sdk.shared.models.common.Component
import io.circe.{Decoder, Encoder, Json}

case class SearchResultCard(title: String,
                            subtitleOne: String,
                            subtitleTwo: String,
                            description: String,
                            lastUpdated: String,
                            icon: String) extends Component derives Decoder, Encoder