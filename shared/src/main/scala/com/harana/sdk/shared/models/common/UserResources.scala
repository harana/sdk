package com.harana.sdk.shared.models.common

import io.circe.{Decoder, Encoder, Json}

case class UserResources(diskSpace: Int,
                         flowsCPU: Int,
                         flowsExecutorCount: Int,
                         flowsExecutorMemory: Int,
                         terminalAllowRoot: Boolean,
                         terminalCPU: Int,
                         terminalMemory: Int) derives Decoder, Encoder