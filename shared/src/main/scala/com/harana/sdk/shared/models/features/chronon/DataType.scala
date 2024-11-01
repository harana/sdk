package com.harana.sdk.shared.models.features.chronon

import io.circe.{Decoder, Encoder}

case class DataType(kind: DataKind,
                    params: Option[List[DataField]] = None,
                    name: Option[String] = None) derives Decoder, Encoder





