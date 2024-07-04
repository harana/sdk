package com.harana.sdk.shared.models.data.connection_types

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup, ParameterValue}
import com.harana.sdk.shared.models.data.ConnectionType

class Snowflake extends ConnectionType {

  // General
  val regionParameter = Parameter.String("region", required = true)
  val accountNameParameter = Parameter.String("account-name", required = true)
  val usernameParameter = Parameter.String("username", required = true)
  val passwordParameter = Parameter.Password("password")
  val generalGroup = ParameterGroup("general", List(regionParameter, accountNameParameter, usernameParameter, passwordParameter))

  // Password
  val authenticationTypeParameter = Parameter.String("authentication-type", required = true, options = List(
    ("password", ParameterValue.String("password")),
    ("private-key", ParameterValue.String("private_key")),
    ("oauth", ParameterValue.String("oauth")),
  ))
  val privateKeyParameter = Parameter.String("private-key")
  val oauthTokenParameter = Parameter.String("oauth-token")
  val warehouseParameter = Parameter.String("warehouse")
  val roleParameter = Parameter.String("role")
  val timezoneParameter = Parameter.String("time-zone", options = List(
    ("spark", ParameterValue.String("spark")),
    ("snowflake", ParameterValue.String("snowflake")),
    ("custom", ParameterValue.String("custom"))
  ))
  val customTimezoneParameter = Parameter.String("custom-time-zone")
  val advancedGroup = ParameterGroup("advanced", List(authenticationTypeParameter, privateKeyParameter, oauthTokenParameter, warehouseParameter,
    roleParameter, timezoneParameter, customTimezoneParameter))

  val parameterGroups = List(generalGroup, advancedGroup)
}