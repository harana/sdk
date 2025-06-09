package com.harana.sdk.shared.models.common

import com.harana.sdk.shared.utils.CirceCodecs.*
import io.circe.{Decoder, Encoder, Json}
import org.latestbit.circe.adt.codec.JsonTaggedAdt

enum ParameterGroupLayout derives JsonTaggedAdt.Codec:
  case List, Grid

case class ParameterGroup(name: String, 
                          parameters: List[Parameter],
                          layout: ParameterGroupLayout = ParameterGroupLayout.List) derives Decoder, Encoder