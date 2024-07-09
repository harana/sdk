package com.harana.sdk.shared.models.features.chronon

import io.circe.generic.JsonCodec

@JsonCodec
case class Aggregation(inputColumn: Option[String] = None,
                       operation: Option[Operation] = None,
                       argMap: Option[Map[String, String]] = None,
                       windows: Option[List[Window]] = None,
                       buckets: Option[List[String]] = None)
