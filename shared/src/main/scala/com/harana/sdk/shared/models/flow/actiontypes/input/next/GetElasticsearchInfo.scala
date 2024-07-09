package com.harana.sdk.shared.models.flow.actiontypes.input.next

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.ConnectionTypes
import com.harana.sdk.shared.models.flow.actiontypes._
import com.harana.sdk.shared.models.flow.actiontypes.input.InputActionTypeInfo

class GetElasticsearchInfo extends InputActionTypeInfo {

  val id = "AC0CDEAA-D9AB-4E96-AE87-CB5DF178FE0F"

  val tags = Set("search")
  val dataSourceType = ConnectionTypes.Elasticsearch

  // General
  val dataSourceParameter = Parameter.Connection("data-source", dataSourceType, required = true)
  val queryParameter = Parameter.String("query", multiLine = true, placeholder = Some("?q=Smith"))
  val generalGroup = ParameterGroup("general", List(dataSourceParameter, pathParameter, queryParameter))

  // Advanced
  val includeMetadataParameter = Parameter.Boolean("include-metadata")
  val includeMetadataVersionParameter = Parameter.Boolean("include-metadata-version")
  val metadataFieldParameter = Parameter.Boolean("metadata-field")
  val pushdownParameter = Parameter.Boolean("pushdown")
  val fieldsToIncludeParameter = Parameter.StringList("fields-to-include")
  val fieldsToExcludeParameter = Parameter.StringList("fields-to-exclude")
  val fieldsToIncludeAsArrayParameter = Parameter.StringList("fields-to-include-as-array")
  val fieldsToExcludeAsArrayParameter = Parameter.StringList("fields-to-exclude-as-array")
  val advancedGroup = ParameterGroup("advanced", List(includeMetadataParameter, includeMetadataVersionParameter, metadataFieldParameter, pushdownParameter,
    fieldsToIncludeParameter, fieldsToExcludeParameter, fieldsToIncludeAsArrayParameter, fieldsToExcludeAsArrayParameter))

  val parameterGroups = List(generalGroup, advancedGroup, logGroup)

}