package com.harana.sdk.shared.models.data

import com.harana.sdk.shared.models.common.ParameterGroup

import scala.scalajs.reflect.annotation.EnableReflectiveInstantiation

@EnableReflectiveInstantiation
trait DataSourceType {
  val parameterGroups: List[ParameterGroup]
  val supportsHadoopInputFormat: Boolean = false
}

object DataSourceType {
  type DataSourceTypeId = String
}