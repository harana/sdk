package com.harana.sdk.shared.models.data

import com.harana.sdk.shared.models.common.Entity.EntityId
import com.harana.sdk.shared.models.common.Parameter.{ParameterName, ParameterValues, ParametersMap}
import com.harana.sdk.shared.models.common.User.UserId
import com.harana.sdk.shared.models.common.{Background, Entity, Parameter, ParameterValue, Status, Visibility}
import com.harana.sdk.shared.models.data.Connection.ConnectionId
import com.harana.sdk.shared.models.data.ConnectionType.ConnectionTypeId
import com.harana.sdk.shared.utils.{HMap, Random}
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

	val allParameterValues = {
		val connection = ConnectionTypes.getById(connectionType)
		val parameters = parameterValues.map { case (name, value) =>
			connection.parameterGroups.flatten(_.parameters).find(_.name == name).head -> value
		} ++ Map(
			Parameter.title -> ParameterValue.String(title),
			Parameter.description -> ParameterValue.String(description),
			Parameter.tags -> ParameterValue.StringList(tags.toList)
		)
		HMap[ParametersMap](parameters.asInstanceOf[Map[Any, Any]])
	}
}

object Connection {
	type ConnectionId = String

	def apply(title: String, description: String, parameterValues: Map[ParameterName, ParameterValue], connectionType: ConnectionTypeId, path: Option[String], createdBy: Option[UserId], visibility: Visibility, background: Option[Background], tags: Set[String]): Connection = {
		apply(title, description, connectionType, parameterValues, path, createdBy, Instant.now, createdBy, Instant.now, None, Random.long, Status.Active, visibility, 1L, background, tags, Map())
	}
}