package com.harana.sdk.shared.models.features.chronon

import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}
import io.circe.syntax.EncoderOps
import io.circe.{Decoder, Encoder}
import org.latestbit.circe.adt.codec.JsonTaggedAdt

enum Source derives JsonTaggedAdt.Decoder, JsonTaggedAdt.Encoder {
  case EntitySource(snapshotTable: Option[String] = None,
                    mutationTable: Option[String] = None,
                    mutationTopic: Option[String] = None,
                    query: Option[Query] = None) extends Source
  
  case EventSource(table: Option[String] = None,
                   topic: Option[String] = None,
                   query: Option[Query] = None,
                   isCumulative: Option[Boolean] = None) extends Source
  
  case JoinSource(join: Option[Join] = None,
                  query: Option[Query] = None) extends Source
}