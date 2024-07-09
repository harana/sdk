package com.harana.sdk.shared.models.features.chronon

import io.circe.derivation.{deriveDecoder, deriveEncoder}
import io.circe.generic.JsonCodec
import io.circe.syntax.EncoderOps
import io.circe.{Decoder, Encoder}

sealed trait Source

@JsonCodec
case class EntitySource(snapshotTable: Option[String] = None,
                        mutationTable: Option[String] = None,
                        mutationTopic: Option[String] = None,
                        query: Option[Query] = None) extends Source

@JsonCodec
case class EventSource(table: Option[String] = None,
                       topic: Option[String] = None,
                       query: Option[Query] = None,
                       isCumulative: Option[Boolean] = None) extends Source

@JsonCodec
case class JoinSource(join: Option[Join] = None,
                      query: Option[Query] = None) extends Source

object Source {

  implicit val decoder: Decoder[Source] = Decoder.instance[Source] { c =>
    val content = c.downField("source").success.get
    c.downField("type").as[String].getOrElse(throw new Exception("Source type not found")) match {
      case "Entity" => deriveDecoder[EntitySource].apply(content)
      case "Event" => deriveDecoder[EventSource].apply(content)
      case "Join" => deriveDecoder[JoinSource].apply(content)
    }
  }

  implicit val encoder: Encoder[Source] = Encoder.instance[Source] { source =>
    val sourceType = source.getClass.getSimpleName
    val json = sourceType match {
      case "Entity" => deriveEncoder[EntitySource].apply(source.asInstanceOf[EntitySource])
      case "Event" => deriveEncoder[EventSource].apply(source.asInstanceOf[EventSource])
      case "Join" => deriveEncoder[JoinSource].apply(source.asInstanceOf[JoinSource])
    }
    io.circe.Json.obj("type" -> sourceType.asJson, "source" -> json)
  }

}