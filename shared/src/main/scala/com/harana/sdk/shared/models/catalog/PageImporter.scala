package com.harana.sdk.shared.models.catalog

import java.time.Instant

import com.harana.sdk.shared.models.common.Entity.EntityId
import com.harana.sdk.shared.models.catalog.PageImporter.PageImporterId
import com.harana.sdk.shared.models.common.Parameter.ParameterName
import com.harana.sdk.shared.models.common.User.UserId
import com.harana.sdk.shared.models.common.{Entity, ParameterValue, Status, User, Visibility}
import io.circe.generic.JsonCodec
import com.harana.sdk.shared.utils.CirceCodecs._
import com.harana.sdk.shared.utils.Random

@JsonCodec
case class PageImporter(name: String,
                        description: String,
                        parameterValues: Map[ParameterName, ParameterValue],
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
    extends Entity with Serializable {

	type EntityType = PageImporter
}

object PageImporter {
	type PageImporterId = String

	def apply(name: String, description: String, parameterValues: Map[ParameterName, ParameterValue], createdBy: Option[User], visibility: Visibility, tags: Set[String]): PageImporter = {
		apply(name, description, parameterValues, createdBy.map(_.id), Instant.now, createdBy.map(_.id), Instant.now, Random.long, Status.Active, visibility, 1L, tags, Map())
	}
}