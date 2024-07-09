package com.harana.sdk.shared.models.features.chronon

import io.circe.generic.JsonCodec

@JsonCodec
case class GroupBy(metaData: Option[MetaData] = None,
                   sources: Option[List[Source]] = None,
                   keyColumns: Option[List[String]] = None,
                   aggregations: Option[List[Aggregation]] = None,
                   accuracy: Option[Accuracy] = None,
                   backfillStartDate: Option[String] = None,
                   derivations: Option[List[Derivation]] = None)
