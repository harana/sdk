package com.harana.sdk.shared.models.flow

import com.harana.sdk.shared.models.common.Entity.EntityId
import com.harana.sdk.shared.models.common.User.UserId
import com.harana.sdk.shared.models.common.{Background, Entity, Status, Visibility}
import com.harana.sdk.shared.models.data.Connection
import com.harana.sdk.shared.models.flow.Flow.FlowId
import com.harana.sdk.shared.utils.Random
import io.circe.generic.JsonCodec
import com.harana.sdk.shared.utils.CirceCodecs._

import java.time.Instant

@JsonCodec
case class Flow(title: String,
                description: String,
                connections: List[Connection] = List(),
                actions: List[Action] = List(),
                links: List[Link] = List(),
                zoomLevel: Option[Int],
                createdBy: Option[UserId],
                created: Instant,
                updatedBy: Option[UserId],
                updated: Instant,
                id: FlowId,
                status: Status,
                visibility: Visibility,
                version: Long,
                background: Background,
                tags: Set[String],
                relationships: Map[String, EntityId])
  extends Entity with Serializable {
  type EntityType = Flow
}

object Flow {
  type FlowId = String

  def apply(title: String,
            description: String,
            connections: List[Connection],
            actions: List[Action],
            links: List[Link],
            createdBy: Option[UserId],
            visibility: Visibility,
            background: Background,
            tags: Set[String]): Flow = {
    apply(title, description, connections, actions, links, None, createdBy, Instant.now, createdBy, Instant.now, Random.long, Status.Active, visibility, 1L, background, tags, Map())
  }
}