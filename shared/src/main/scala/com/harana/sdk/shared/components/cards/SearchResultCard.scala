package com.harana.sdk.shared.components.cards

import com.harana.sdk.shared.models.common.{Component, User}
import io.circe.{Decoder, Encoder, Json}

case class SearchResultCard(user: User,
                            showTitle: Boolean,
                            showSocial: Boolean,
                            showMessaging: Boolean,
                            value: String) extends Component derives Decoder, Encoder