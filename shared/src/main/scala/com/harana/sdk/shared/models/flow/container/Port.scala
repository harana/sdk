package com.harana.sdk.shared.models.flow.container



case class Port(name: String,
                internal: Option[Int],
                external: Option[Int])