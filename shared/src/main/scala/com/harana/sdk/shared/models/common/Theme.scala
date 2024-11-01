package com.harana.sdk.shared.models.common

import java.time.Instant

import com.harana.sdk.shared.models.common.Entity.EntityId
import com.harana.sdk.shared.models.common.ParameterName
import com.harana.sdk.shared.models.common.Theme.ThemeId
import com.harana.sdk.shared.models.common.User.UserId
import com.harana.sdk.shared.utils.CirceCodecs._
import com.harana.sdk.shared.utils.Random
import io.circe.{Decoder, Encoder}

case class Theme(name: String,
								 description: String,
								 parameterValues: Map[ParameterName, Any],
								 createdBy: Option[UserId],
								 created: Instant,
								 updatedBy: Option[UserId],
								 updated: Instant,
								 id: ThemeId,
								 status: Status,
								 visibility: Visibility,
								 version: Long,
								 tags: Set[String],
								 relationships: Map[String, EntityId])
    extends Entity with Serializable derives Decoder, Encoder {

	type EntityType = Theme
}

object Theme {
	type ThemeId = String

	def apply(name: String, description: String, parameterValues: Map[ParameterName, Any], createdBy: Option[User], visibility: Visibility, tags: Set[String]): Theme = {
		apply(name, description, parameterValues, createdBy.map(_.id), Instant.now, createdBy.map(_.id), Instant.now, Random.long, Status.Active, visibility, 1L, tags, Map())
	}
}