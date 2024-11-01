package com.harana.sdk.shared.models.flow.container



case class Docker(image: Option[String],
                  repository: Option[String],
                  path: Option[String])