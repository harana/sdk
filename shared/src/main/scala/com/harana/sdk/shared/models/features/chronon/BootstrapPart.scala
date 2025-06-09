package com.harana.sdk.shared.models.features.chronon

import io.circe.{Decoder, Encoder, Json}

case class BootstrapPart(metaData: Option[MetaData] = None,
                         table: Option[String] = None,
                         query: Option[Query] = None,
                         keyColumns: Option[List[String]] = None) derives Decoder, Encoder
