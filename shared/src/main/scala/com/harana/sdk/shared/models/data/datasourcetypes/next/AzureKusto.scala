package com.harana.sdk.shared.models.data.datasourcetypes.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup, ParameterValue}
import com.harana.sdk.shared.models.data.DataSourceType

import scala.scalajs.reflect.annotation.EnableReflectiveInstantiation

@EnableReflectiveInstantiation
class AzureKusto extends DataSourceType {

  // General
  val clusterParameter = Parameter.String("cluster", required = true)
  val regionParameter = Parameter.String("region", required = true)
  val authenticationTypeParameter = Parameter.String("authenticationType", required = true, options = List(
    ("application", "application"),
    ("keyVault", "keyVault"),
    ("direct", "direct")
  ))
  val keyValueAppIdParameter = Parameter.String("keyVaultAppId")
  val keyValueAppKeyParameter = Parameter.String("keyVaultAppKey")
  val aadClientIdParameter = Parameter.String("aadClientId")
  val aadAuthorityIdParameter = Parameter.String("aadAuthorityId")
  val aadClientPasswordParameter = Parameter.Password("aadClientPassword")
  val generalGroup = ParameterGroup("general", List(clusterParameter, regionParameter, authenticationTypeParameter, keyValueAppIdParameter, keyValueAppKeyParameter, aadClientIdParameter, aadAuthorityIdParameter, aadClientPasswordParameter))

  // Advanced
  val asyncParameter = Parameter.Boolean("async", default = Some(ParameterValue.Boolean(false)))
  val advancedGroup = ParameterGroup("advanced", List(asyncParameter))

  val parameterGroups = List(generalGroup, advancedGroup)
}