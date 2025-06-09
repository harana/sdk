package com.harana.sdk.shared.models.features.chronon

import io.circe.{Decoder, Encoder, Json}

case class ExternalSource(metadata: Option[MetaData] = None,
                          keySchema: Option[DataType] = None,
                          valueSchema: Option[DataType] = None) derives Decoder, Encoder
