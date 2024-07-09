package com.harana.sdk.shared.models.features.chronon

import io.circe.generic.JsonCodec

@JsonCodec
case class StagingQuery(metaData: Option[MetaData] = None,
                        query: Option[String] = None,
                        startPartition: Option[String] = None,
                        setups: Option[List[String]] = None)
