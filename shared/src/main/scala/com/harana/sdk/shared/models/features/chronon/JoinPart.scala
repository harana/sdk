package com.harana.sdk.shared.models.features.chronon

import io.circe.generic.JsonCodec

@JsonCodec
case class JoinPart(groupBy: Option[GroupBy] = None,
                    keyMapping: Option[Map[String, String]] = None,
                    prefix: Option[String] = None)
