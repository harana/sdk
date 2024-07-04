package com.harana.sdk.shared.models.data

import com.harana.sdk.shared.models.common.Entity.EntityId
import com.harana.sdk.shared.models.common.Parameter.{ParameterName, ParameterValues}
import com.harana.sdk.shared.models.common.User.UserId
import com.harana.sdk.shared.models.common.{Background, Entity, ParameterValue, Status, Visibility}
import com.harana.sdk.shared.models.data.Connection.ConnectionId
import com.harana.sdk.shared.models.data.ConnectionType.ConnectionTypeId
import com.harana.sdk.shared.utils.Random
import io.circe.generic.JsonCodec
import com.harana.sdk.shared.utils.CirceCodecs._

import java.time.Instant

@JsonCodec
case class Connection(title: String,
											description: String,
											connectionType: ConnectionTypeId,
											parameterValues: Map[ParameterName, ParameterValue],
											path: Option[String],
											createdBy: Option[UserId],
											created: Instant,
											updatedBy: Option[UserId],
											updated: Instant,
											lastSynced: Option[Instant],
											id: ConnectionId,
											status: Status,
											visibility: Visibility,
											version: Long,
											background: Option[Background],
											tags: Set[String],
											relationships: Map[String, EntityId])
	extends Entity with Serializable {

	type EntityType = Connection

	def parameters = {
		val connection = ConnectionTypes.get
		parameterValues.map { case (name, value) =>

		}
	}

}

object Connection {
	type ConnectionId = String

	def apply(title: String, description: String, parameterValues: Map[ParameterName, ParameterValue], connectionType: ConnectionTypeId, path: Option[String], createdBy: Option[UserId], visibility: Visibility, background: Option[Background], tags: Set[String]): Connection = {
		apply(title, description, connectionType, parameterValues, path, createdBy, Instant.now, createdBy, Instant.now, None, Random.long, Status.Active, visibility, 1L, background, tags, Map())
	}
}