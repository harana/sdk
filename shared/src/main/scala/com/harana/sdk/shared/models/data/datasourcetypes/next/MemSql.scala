package com.harana.sdk.shared.models.data.datasourcetypes.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup, ParameterValue}
import com.harana.sdk.shared.models.data.DataSourceType

import scala.scalajs.reflect.annotation.EnableReflectiveInstantiation

@EnableReflectiveInstantiation
class MemSql extends DataSourceType {

  // General
  val hostParameter = Parameter.IPAddress("host", port = true, portDefault = Some(3306), required = true)
  val usernameParameter = Parameter.String("username", required = true)
  val passwordParameter = Parameter.Password("password", required = true)
  val generalGroup = ParameterGroup("general", List(hostParameter, usernameParameter, passwordParameter))

  // Advanced
  val defaultDatabaseParameter = Parameter.String("defaultDatabase")
  val defaultSaveModeParameter = Parameter.String("defaultSaveMode", options = List(
    ("error", "error"),
    ("ignore", "ignore"),
    ("overwrite", "overwrite")
  ))
  val disablePartitionPushdownParameter = Parameter.Boolean("disablePartitionPushdown", default = Some(ParameterValue.Boolean(false)))
  val defaultCreateModeParameter = Parameter.String("defaultCreateMode", options = List(
    ("databaseAndTable", "databaseAndTable"),
    ("skip", "skip"),
    ("table", "table")
  ))
  val trustServerCertificate = Parameter.Boolean("trustServerCertificate")
  val disableSslHostnameVerification = Parameter.Boolean("disableSslHostnameVerification")
  val advancedGroup = ParameterGroup("advanced", List(defaultDatabaseParameter, defaultSaveModeParameter, disablePartitionPushdownParameter, defaultCreateModeParameter, trustServerCertificate, disableSslHostnameVerification))

  val parameterGroups = List(generalGroup, advancedGroup)
}