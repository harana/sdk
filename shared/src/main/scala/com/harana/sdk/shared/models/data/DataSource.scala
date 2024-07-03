package com.harana.sdk.shared.models.data

import java.time.Instant

import com.harana.sdk.shared.models.common.Entity.EntityId
import com.harana.sdk.shared.models.common.Parameter.ParameterName
import com.harana.sdk.shared.models.common.User.UserId
import com.harana.sdk.shared.models.common.{Background, Entity, ParameterValue, Status, User, Visibility}
import com.harana.sdk.shared.models.data.DataSource.DataSourceId
import com.harana.sdk.shared.utils.Random
import io.circe.generic.JsonCodec
import com.harana.sdk.shared.utils.CirceCodecs._

@JsonCodec
case class DataSource(title: String,
											description: String,
											createdBy: Option[UserId],
											created: Instant,
											updatedBy: Option[UserId],
											updated: Instant,
											id: DataSourceId,
											status: Status,
											visibility: Visibility,
											version: Long,
											background: Background,
											tags: Set[String],
											relationships: Map[String, EntityId],
											dataSourceType: DataSourceType,
											parameterValues: Map[ParameterName, ParameterValue])
    extends Entity with Serializable {

	type EntityType = DataSource
}

object DataSource {
	type DataSourceId = String

	def apply(title: String, description: String, createdBy: Option[UserId], visibility: Visibility, background: Background, tags: Set[String], dataSourceType: DataSourceType, parameterValues: Map[ParameterName, ParameterValue]): DataSource = {
		apply(title, description, createdBy, Instant.now, createdBy, Instant.now, Random.long, Status.Active, visibility, 1L, background, tags, Map(), dataSourceType, parameterValues)
	}
}