
package com.harana.sdk.shared.models.features.chronon

import io.circe.{Decoder, Encoder, Json}

case class DataField(name: Option[String] = None,
                     dataType: Option[DataType] = None) derives Decoder, Encoder
