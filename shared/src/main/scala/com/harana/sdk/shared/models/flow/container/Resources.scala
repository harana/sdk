package com.harana.sdk.shared.models.flow.container

import io.circe.generic.JsonCodec

@JsonCodec
case class Resources(cpu: Option[String],
                     memory: Option[String])