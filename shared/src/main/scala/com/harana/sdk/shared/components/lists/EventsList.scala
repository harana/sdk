package com.harana.sdk.shared.components.lists

import com.harana.sdk.shared.models.common.{Component, Event}
import io.circe.{Decoder, Encoder}

case class EventsList(title: String,
                      icon: Option[String] = None,
                      events: List[Event] = List.empty) extends Component derives Decoder, Encoder
