package com.harana.sdk.shared.models.flow.container



case class Python(repository: Option[String],
                  path: Option[String],
                  file: Option[String],
                  baseImage: Option[String])