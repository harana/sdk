package com.harana.sdk.shared.models.flow.container

import io.circe.generic.JsonCodec

@JsonCodec
case class Repository(name: String,
                      git: Git)