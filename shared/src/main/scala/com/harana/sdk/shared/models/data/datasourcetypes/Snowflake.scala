package com.harana.sdk.shared.models.data.datasourcetypes

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.DataSourceType

class Snowflake extends DataSourceType {

  // General
  val regionParameter = Parameter.String("region", required = true)
  val accountNameParameter = Parameter.String("account-name", required = true)
  val usernameParameter = Parameter.String("username", required = true)
  val passwordParameter = Parameter.Password("password")
  val generalGroup = ParameterGroup("general", List(regionParameter, accountNameParameter, usernameParameter, passwordParameter))

  // Password
  val authenticationTypeParameter = Parameter.String("authentication-type", required = true, options = List(
    ("password", "password"),
    ("private-key", "private_key"),
    ("oauth", "oauth"),
  ))
  val privateKeyParameter = Parameter.String("private-key")
  val oauthTokenParameter = Parameter.String("oauth-token")
  val warehouseParameter = Parameter.String("warehouse")
  val roleParameter = Parameter.String("role")
  val timezoneParameter = Parameter.String("time-zone", options = List(
    ("spark", "spark"),
    ("snowflake", "snowflake"),
    ("custom", "custom")
  ))
  val customTimezoneParameter = Parameter.String("custom-time-zone")
  val advancedGroup = ParameterGroup("advanced", List(authenticationTypeParameter, privateKeyParameter, oauthTokenParameter, warehouseParameter,
    roleParameter, timezoneParameter, customTimezoneParameter))

  val parameterGroups = List(generalGroup, advancedGroup)
}