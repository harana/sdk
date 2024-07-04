package com.harana.sdk.shared.models.data.connection_types.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup, ParameterValue}
import com.harana.sdk.shared.models.data.ConnectionType

import scala.scalajs.reflect.annotation.EnableReflectiveInstantiation

@EnableReflectiveInstantiation
class Ceph extends ConnectionType {

  val id = "4466B51C-9E62-46AC-BEEE-526EFD8009F8"

  // General
  val hostParameter = Parameter.IPAddress("host", port = true, portDefault = Some(8000))
  val sslParameter = Parameter.Boolean("ssl", default = Some(ParameterValue.Boolean(true)))
  val accessKeyParameter = Parameter.String("accessKey", required = true)
  val secretKeyParameter = Parameter.String("secretKey", required = true)
  val generalGroup = ParameterGroup("general", List(hostParameter, sslParameter, accessKeyParameter, secretKeyParameter))

  val parameterGroups = List(generalGroup)

}