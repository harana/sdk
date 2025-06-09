package com.harana.sdk.shared.models.catalog

import java.time.Instant
import com.harana.sdk.shared.models.common.Entity.EntityId
import com.harana.sdk.shared.models.catalog.PageImporter.PageImporterId
import com.harana.sdk.shared.models.common.{Entity, ParameterValues, ParameterValue, Status, User, Visibility}
import com.harana.sdk.shared.models.common.User.UserId
import com.harana.sdk.shared.utils.CirceCodecs.*
import com.harana.sdk.shared.utils.Random
import io.circe.{Decoder, Encoder, Json}

case class PageImporter(name: String,
                        description: String,
                        values: ParameterValues,
                        createdBy: Option[UserId],
                        created: Instant,
                        updatedBy: Option[UserId],
                        updated: Instant,
												id: PageImporterId,
                        status: Status,
												visibility: Visibility,
												version: Long,
											  tags: Set[String],
                        relationships: Map[String, EntityId])
    extends Entity with Serializable derives Decoder, Encoder {

	type EntityType = PageImporter
}

object PageImporter {
	type PageImporterId = String

	def apply(name: String, description: String, values: ParameterValues, createdBy: Option[User], visibility: Visibility, tags: Set[String]): PageImporter = {
		apply(name, description, values, createdBy.map(_.id), Instant.now, createdBy.map(_.id), Instant.now, Random.long, Status.Active, visibility, 1L, tags, Map())
	}
}