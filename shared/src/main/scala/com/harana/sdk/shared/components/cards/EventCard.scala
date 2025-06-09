package com.harana.sdk.shared.components.cards

import com.harana.sdk.shared.models.common.{Component, Event}
import io.circe.{Decoder, Encoder, Json}

case class EventCard(event: Event,
                     showTitle: Boolean,
                     showSocial: Boolean,
                     showMessaging: Boolean,
                     value: String) extends Component derives Decoder, Encoder