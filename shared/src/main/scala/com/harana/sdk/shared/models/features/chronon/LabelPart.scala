package com.harana.sdk.shared.models.features.chronon

import io.circe.{Decoder, Encoder, Json}

case class LabelPart(labels: Option[List[JoinPart]] = None,
                     leftStartOffset: Option[Int] = None,
                     leftEndOffset: Option[Int] = None,
                     metaData: Option[MetaData] = None) derives Decoder, Encoder