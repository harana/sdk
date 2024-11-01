package com.harana.sdk.shared.models.flow.container



case class Scala(repository: Option[String],
                 path: Option[String],
                 baseImage: Option[String],
                 sbt: Option[SBT])