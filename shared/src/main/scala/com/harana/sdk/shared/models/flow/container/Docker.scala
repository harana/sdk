package com.harana.sdk.shared.models.flow.container

import io.circe.generic.JsonCodec

@JsonCodec
case class Docker(image: Option[String],
                  repository: Option[String],
                  path: Option[String])