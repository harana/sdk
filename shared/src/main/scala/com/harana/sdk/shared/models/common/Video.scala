package com.harana.sdk.shared.models.common

import java.time.Instant

import com.harana.sdk.shared.models.common.Entity.EntityId
import com.harana.sdk.shared.models.common.User.UserId
import com.harana.sdk.shared.models.common.Video.VideoId
import com.harana.sdk.shared.utils.CirceCodecs._
import com.harana.sdk.shared.utils.Random
import io.circe.{Decoder, Encoder, Json}

case class Video(name: String,
                 description: String,
                 fileName: String,
                 fileSize: Long,
                 width: Int,
                 height: Int,
                 playTime: Long,
                 mimeType: String,
                 createdBy: Option[UserId],
                 created: Instant,
                 updatedBy: Option[UserId],
                 updated: Instant,
                 id: VideoId,
                 status: Status,
								 visibility: Visibility,
                 version: Long,
								 tags: Set[String],
                 relationships: Map[String, EntityId])
    extends Entity with Serializable derives Decoder, Encoder {

	type EntityType = Video
}

object Video {
	type VideoId = String

	def apply(name: String, description: String, fileName: String, fileSize: Long, width: Int, height: Int, playTime: Long, mimeType: String, createdBy: Option[User], visibility: Visibility, tags: Set[String]): Video = {
		apply(name, description, fileName, fileSize, width, height, playTime, mimeType, createdBy.map(_.id), Instant.now, createdBy.map(_.id), Instant.now, Random.long, Status.Active, visibility, 1L, tags, Map())
	}
}