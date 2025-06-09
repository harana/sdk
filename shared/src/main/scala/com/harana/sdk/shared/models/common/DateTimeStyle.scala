package com.harana.sdk.shared.models.common

import org.latestbit.circe.adt.codec.JsonTaggedAdt

enum DateTimeStyle derives JsonTaggedAdt.Codec:
  case None, Short, Medium, Long, Full