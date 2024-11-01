package com.harana.sdk.shared.models.catalog

import java.time.Instant
import com.harana.sdk.shared.models.catalog.Panel.PanelId
import com.harana.sdk.shared.models.catalog.UserPanelType.UserPanelTypeId
import com.harana.sdk.shared.models.common.Entity.EntityId
import com.harana.sdk.shared.models.common.{Entity, ParameterMap, ParameterName, Status, User, Visibility}
import com.harana.sdk.shared.models.common.User.UserId
import com.harana.sdk.shared.plugin.PanelType.PanelTypeId
import com.harana.sdk.shared.utils.CirceCodecs.*
import com.harana.sdk.shared.utils.Random
import io.circe.{Decoder, Encoder}


case class Panel(name: String,
                 title: String,
                 description: String,
                 panelTypeId: Either[PanelTypeId, UserPanelTypeId],
                 parameterValues: Map[ParameterName, Any],
                 createdBy: Option[UserId],
                 created: Instant,
                 updatedBy: Option[UserId],
                 updated: Instant,
								 id: PanelId,
                 status: Status,
								 visibility: Visibility,
								 version: Long,
								 tags: Set[String],
                 relationships: Map[String, EntityId])
    extends Entity with Serializable derives Decoder, Encoder {

	type EntityType = Panel
}

object Panel {
	type PanelSlotId = String
	type PanelId = String

	def apply[PT, P](panelType: Either[PanelType, UserPanelType], parameterValues: Map[ParameterName, Any], createdBy: Option[User], visibility: Visibility, tags: Set[String]): Panel = {
		panelType match {
			case Left(l) => apply(l.name, l.title, l.description, Left(l.id), parameterValues, createdBy.map(_.id), Instant.now, createdBy.map(_.id), Instant.now, Random.long, Status.Active, visibility, 1L, tags, Map())
			case Right(r) => apply(r.name, r.title, r.description, Right(r.id), parameterValues, createdBy.map(_.id), Instant.now, createdBy.map(_.id), Instant.now, Random.long, Status.Active, visibility, 1L, tags, Map())
		}
	}

	def apply(name: String, title: String, description: String, panelTypeId: Either[PanelTypeId, UserPanelTypeId], parameterValues: Map[ParameterName, Any], createdBy: Option[User],visibility: Visibility, tags: Set[String]): Panel = {
		apply(name, title, description, panelTypeId, parameterValues, createdBy.map(_.id), Instant.now, createdBy.map(_.id), Instant.now, Random.long, Status.Active, visibility, 1L, tags, Map())
	}
}