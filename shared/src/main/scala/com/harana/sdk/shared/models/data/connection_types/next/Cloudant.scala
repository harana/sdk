package com.harana.sdk.shared.models.data.connection_types.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.{ConnectionType, SyncDirection}
import com.harana.sdk.shared.models.common.ParameterValue.given
import scala.scalajs.reflect.annotation.EnableReflectiveInstantiation

@EnableReflectiveInstantiation
class Cloudant extends ConnectionType {

  val id = "2AC220A7-9520-4602-87EB-58248C08B112"

  // General
  val hostParameter = Parameter.IPAddress("host", required = true)
  val sslParameter = Parameter.Boolean("ssl")
  val usernameParameter = Parameter.String("username", required = true)
  val passwordParameter = Parameter.Password("password", required = true)
  val generalGroup = ParameterGroup("general", List(hostParameter, sslParameter, usernameParameter, passwordParameter))

  // Advanced
  val queryTimeoutParameter = Parameter.Long("queryTimeout", default = 60000)
  val batchIntervalParameter = Parameter.Long("batchInterval", default = 8)
  val endpointParameter = Parameter.String("endpoint", options = List(
    ("allDocs", "_all_docs"),
    ("changes", "_changes")
  ))
  val useQueryParameter = Parameter.Boolean("useQuery")
  val retryCountParameter = Parameter.Long("retryCount", default = 3)
  val queryLimitParameter = Parameter.Long("queryLimit", default = 25)

  val bulkSizeParameter = Parameter.Long("bulkSize", placeholder = Some(200))
  val schemaSampleSizeParameter = Parameter.Long("schemaSampleSize", placeholder = Some(-1))
  val selectorParameter = Parameter.Json("selector")
  val createDatabaseOnSaveParameter = Parameter.Boolean("createDatabaseOnSave")

  val advancedGroup = ParameterGroup("advanced", List(queryTimeoutParameter,
    batchIntervalParameter, endpointParameter, useQueryParameter, retryCountParameter, queryLimitParameter,
    bulkSizeParameter, schemaSampleSizeParameter, selectorParameter, createDatabaseOnSaveParameter
  ))

  val parameterGroups = List(generalGroup, advancedGroup)
  val syncDirection = SyncDirection.Bidirectional

}