package com.harana.sdk.shared.models.features.chronon

import io.circe.generic.JsonCodec

@JsonCodec
case class AggregationPart(inputColumn: Option[String] = None,
                           operation: Option[Operation] = None,
                           argMap: Option[Map[String, String]] = None,
                           window: Option[Window] = None,
                           bucket: Option[String] = None)
