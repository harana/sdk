package com.harana.sdk.shared.models.data.datasourcetypes.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup, ParameterValue}
import com.harana.sdk.shared.models.data.DataSourceType

import scala.scalajs.reflect.annotation.EnableReflectiveInstantiation

@EnableReflectiveInstantiation
class Ceph extends DataSourceType {

  // General
  val hostParameter = Parameter.IPAddress("host", port = true, portDefault = Some(8000))
  val sslParameter = Parameter.Boolean("ssl", default = Some(ParameterValue.Boolean(true)))
  val accessKeyParameter = Parameter.String("accessKey", required = true)
  val secretKeyParameter = Parameter.String("secretKey", required = true)
  val generalGroup = ParameterGroup("general", List(hostParameter, sslParameter, accessKeyParameter, secretKeyParameter))

  val parameterGroups = List(generalGroup)

  override val supportsHadoopInputFormat = true
}