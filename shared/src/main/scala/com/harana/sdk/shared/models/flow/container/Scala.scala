package com.harana.sdk.shared.models.flow.container

import io.circe.generic.JsonCodec

@JsonCodec
case class Scala(repository: Option[String],
                 path: Option[String],
                 baseImage: Option[String],
                 sbt: Option[SBT])