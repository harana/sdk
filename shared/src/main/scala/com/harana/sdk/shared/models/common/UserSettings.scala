package com.harana.sdk.shared.models.common

import io.circe.{Decoder, Encoder}

case class UserSettings(fileSharingEnabled: Boolean = false,
												fileSharingUsername: Option[String] = None,
												fileSharingPassword: Option[String] = None,
												remoteLoginEnabled: Boolean = false,
												remoteLoginUsername: Option[String] = None,
												remoteLoginPassword: Option[String] = None,
												sshImage: Option[String] = None) derives Decoder, Encoder