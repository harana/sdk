package com.harana.sdk.shared.models.common

import com.harana.sdk.shared.models.common.Entity.EntityId
import com.harana.sdk.shared.models.common.User.UserId
import io.circe.*
import org.latestbit.circe.adt.codec.JsonTaggedAdt
import java.time.Instant

enum Status derives JsonTaggedAdt.Codec:
  case Active, Paused, Deleted

trait Entity extends Id:
  type EntityType <: Entity

  val createdBy: Option[UserId]
  val created: Instant
  val updated: Instant
  val updatedBy: Option[UserId]
  val id: EntityId
  val status: Status
  val version: Long
  val tags: Set[String]
  val relationships: Map[String, EntityId]

object Entity:
  type EntityId = String