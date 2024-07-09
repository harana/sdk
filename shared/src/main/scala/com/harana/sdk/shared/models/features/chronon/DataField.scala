
package com.harana.sdk.shared.models.features.chronon

import io.circe.generic.JsonCodec

@JsonCodec
case class DataField(name: Option[String] = None,
                     dataType: Option[DataType] = None)
