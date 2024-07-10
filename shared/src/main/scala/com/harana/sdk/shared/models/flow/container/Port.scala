package com.harana.sdk.shared.models.flow.container

import io.circe.generic.JsonCodec

@JsonCodec
case class Port(name: String,
                internal: Option[Int],
                external: Option[Int])