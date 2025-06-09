package com.harana.sdk.shared.models.data

import com.harana.sdk.shared.models.common.Entity.EntityId
import com.harana.sdk.shared.models.common.User.UserId
import com.harana.sdk.shared.models.common.{Background, Entity, Parameter, ParameterName, ParameterValues, Status, Visibility}
import com.harana.sdk.shared.models.data.Connection.ConnectionId
import com.harana.sdk.shared.models.data.ConnectionType.ConnectionTypeId
import com.harana.sdk.shared.utils.Random
import com.harana.sdk.shared.utils.CirceCodecs.*
import io.circe.{Decoder, Encoder, Json}
import com.harana.sdk.shared.models.common.ParameterValues.given

import java.time.Instant

case class Connection(title: String,
											description: String,
											connectionType: ConnectionTypeId,
											values: ParameterValues,
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
	extends Entity with Serializable derives Decoder, Encoder {

	type EntityType = Connection

//	val allParameterValues = {
//		val connection = ConnectionTypes.getById(connectionType)
//		val parameters = values.unsafeToHashMap.map { case (name, value) =>
//			connection.parameterGroups.flatten(_.parameters).find(_.name == name).head -> value
//		} ++ Map(
//			Parameter.title -> title,
//			Parameter.description -> description,
//			Parameter.tags -> tags.toList
//		)
//		parameters
//	}
}

object Connection {
	type ConnectionId = String

	def apply(title: String, description: String, values: ParameterValues, connectionType: ConnectionTypeId, path: Option[String], createdBy: Option[UserId], visibility: Visibility, background: Option[Background], tags: Set[String]): Connection = {
		apply(title, description, connectionType, values, path, createdBy, Instant.now, createdBy, Instant.now, None, Random.long, Status.Active, visibility, 1L, background, tags, Map())
	}
}