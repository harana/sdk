package com.harana.sdk.shared.models.catalog

import java.time.Instant
import com.harana.sdk.shared.models.common.Entity.EntityId
import com.harana.sdk.shared.models.catalog.PageType.PageTypeId
import com.harana.sdk.shared.models.common.{Entity, Parameter, ParameterName, Status, User, Visibility}
import com.harana.sdk.shared.models.common.User.UserId
import com.harana.sdk.shared.utils.CirceCodecs.*
import com.harana.sdk.shared.utils.Random
import io.circe.{Decoder, Encoder, Json}
import com.harana.sdk.shared.models.common.ParameterValue.given

case class PageType(name: String,
                    description: String,
										parameters: List[Parameter],
                    createdBy: Option[UserId],
                    created: Instant,
                    updatedBy: Option[UserId],
                    updated: Instant,
										id: PageTypeId,
                    status: Status,
										visibility: Visibility,
										version: Long,
										tags: Set[String],
                    relationships: Map[String, EntityId])
    extends Entity with Serializable derives Decoder, Encoder {

	type EntityType = PageType
}

object PageType {
	type PageTypeId = String

	def apply(name: String, description: String, parameters: List[Parameter], createdBy: Option[User], visibility: Visibility, tags: Set[String]): PageType = {
		apply(name, description, parameters, createdBy.map(_.id), Instant.now, createdBy.map(_.id), Instant.now, Random.long, Status.Active, visibility, 1L, tags, Map())
	}
}