package com.harana.sdk.shared.models.catalog

import java.time.Instant
import com.harana.sdk.shared.models.catalog.PageTypeSupplier.PageTypeSupplierId
import com.harana.sdk.shared.models.common.Entity.EntityId
import com.harana.sdk.shared.models.common.{Entity, ParameterMap, ParameterName, Status, User, Visibility}
import com.harana.sdk.shared.models.common.User.UserId
import com.harana.sdk.shared.utils.CirceCodecs.*
import com.harana.sdk.shared.utils.Random
import io.circe.{Decoder, Encoder}

case class PageTypeSupplier(name: String,
                            description: String,
                            parameterValues: Map[ParameterName, Any],
                            createdBy: Option[UserId],
                            created: Instant,
                            updatedBy: Option[UserId],
                            updated: Instant,
														id: PageTypeSupplierId,
                            status: Status,
														visibility: Visibility,
														version: Long,
													  tags: Set[String],
                            relationships: Map[String, EntityId])
    extends Entity with Serializable derives Decoder, Encoder {

	type EntityType = PageTypeSupplier
}

object PageTypeSupplier {
	type PageTypeSupplierId = String

	def apply(name: String, description: String, parameterValues: Map[ParameterName, Any], createdBy: Option[User], visibility: Visibility, tags: Set[String]): PageTypeSupplier = {
		apply(name, description, parameterValues, createdBy.map(_.id), Instant.now, createdBy.map(_.id), Instant.now, Random.long, Status.Active, visibility, 1L, tags, Map())
	}
}