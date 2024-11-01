package com.harana.sdk.shared.models.schedules

import com.harana.sdk.shared.models.common.Entity.EntityId
import com.harana.sdk.shared.models.common.{Entity, ParameterMap, ParameterName, Status, Visibility}
import com.harana.sdk.shared.models.common.User.UserId
import com.harana.sdk.shared.models.schedules.Notifier.NotifierId
import com.harana.sdk.shared.utils.CirceCodecs.*
import com.harana.sdk.shared.utils.Random
import io.circe.{Decoder, Encoder}

import java.time.Instant

case class Notifier[T](title: String,
                    description: String,
                    `type`: NotifierType,
                    parameterValues: Map[ParameterName, Any],
                    createdBy: Option[UserId],
                    created: Instant,
                    updatedBy: Option[UserId],
                    updated: Instant,
                    id: NotifierId,
                    status: Status,
                    visibility: Visibility,
                    version: Long,
                    tags: Set[String],
                    relationships: Map[String, EntityId])
  extends Entity with Serializable derives Decoder, Encoder {

  type EntityType = Notifier[T]
}

object Notifier {
  type NotifierId = String
}