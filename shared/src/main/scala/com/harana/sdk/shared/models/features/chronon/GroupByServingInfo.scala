package com.harana.sdk.shared.models.features.chronon

import io.circe.{Decoder, Encoder, Json}

case class GroupByServingInfo(groupBy: Option[GroupBy] = None,
                              inputAvroSchema: Option[String] = None,
                              selectedAvroSchema: Option[String] = None,
                              keyAvroSchema: Option[String] = None,
                              batchEndDate: Option[String] = None,
                              dateFormat: Option[String] = None) derives Decoder, Encoder
