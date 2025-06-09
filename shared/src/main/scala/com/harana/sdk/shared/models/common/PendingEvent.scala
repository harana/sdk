package com.harana.sdk.shared.models.common

import io.circe.{Decoder, Encoder, Json}
import java.time.Instant

case class PendingEvent(id: String,
												address: String,
												`type`: String,
												payload: String,
												created: Instant = Instant.now) extends Id with Serializable derives Decoder, Encoder {
	type EntityType = PendingEvent
}