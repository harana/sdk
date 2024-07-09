package com.harana.sdk.shared.models.features.chronon

import io.circe.generic.JsonCodec

@JsonCodec
case class Query(selects: Option[Map[String, String]] = None,
                 wheres: Option[List[String]] = None,
                 startPartition: Option[String] = None,
                 endPartition: Option[String] = None,
                 timeColumn: Option[String] = None,
                 setups: Option[List[String]] = Some(List.empty),
                 mutationTimeColumn: Option[String] = None,
                 reversalColumn: Option[String] = None)