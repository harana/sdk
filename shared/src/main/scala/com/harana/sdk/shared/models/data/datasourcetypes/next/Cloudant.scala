package com.harana.sdk.shared.models.data.datasourcetypes.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup, ParameterValue}
import com.harana.sdk.shared.models.data.DataSourceType

import scala.scalajs.reflect.annotation.EnableReflectiveInstantiation

@EnableReflectiveInstantiation
class Cloudant extends DataSourceType {

  // General
  val hostParameter = Parameter.IPAddress("host", required = true)
  val sslParameter = Parameter.Boolean("ssl", default = Some(ParameterValue.Boolean(false)))
  val usernameParameter = Parameter.String("username", required = true)
  val passwordParameter = Parameter.Password("password", required = true)
  val generalGroup = ParameterGroup("general", List(hostParameter, sslParameter, usernameParameter, passwordParameter))

  // Advanced
  val queryTimeoutParameter = Parameter.Long("queryTimeout", default = Some(ParameterValue.Long(60000)))
  val batchIntervalParameter = Parameter.Long("batchInterval", default = Some(ParameterValue.Long(8)))
  val endpointParameter = Parameter.String("endpoint", options = List(
    ("allDocs", "_all_docs"),
    ("changes", "_changes")
  ))
  val useQueryParameter = Parameter.Boolean("useQuery", default = Some(ParameterValue.Boolean(false)))
  val retryCountParameter = Parameter.Long("retryCount", default = Some(ParameterValue.Long(3)))
  val queryLimitParameter = Parameter.Long("queryLimit", default = Some(ParameterValue.Long(25)))

  val bulkSizeParameter = Parameter.Long("bulkSize", placeholder = Some(200))
  val schemaSampleSizeParameter = Parameter.Long("schemaSampleSize", placeholder = Some(-1))
  val selectorParameter = Parameter.Json("selector")
  val createDatabaseOnSaveParameter = Parameter.Boolean("createDatabaseOnSave")

  val advancedGroup = ParameterGroup("advanced", List(queryTimeoutParameter,
    batchIntervalParameter, endpointParameter, useQueryParameter, retryCountParameter, queryLimitParameter,
    bulkSizeParameter, schemaSampleSizeParameter, selectorParameter, createDatabaseOnSaveParameter
  ))

  val parameterGroups = List(generalGroup, advancedGroup)
}