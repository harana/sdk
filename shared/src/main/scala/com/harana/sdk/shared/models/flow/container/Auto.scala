package com.harana.sdk.shared.models.flow.container



case class Auto(repository: Option[String],
                path: Option[String],
                builder: Option[String])