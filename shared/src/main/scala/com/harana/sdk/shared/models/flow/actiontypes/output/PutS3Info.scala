package com.harana.sdk.shared.models.flow.actiontypes.output

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup, ParameterValue}
import com.harana.sdk.shared.models.data.ConnectionTypes
import com.harana.sdk.shared.models.flow.actiontypes._

class PutS3Info extends OutputActionTypeInfo {

  val tags = Set("aws")
  val dataSourceType = ConnectionTypes.S3

  // General
  val dataSourceParameter = Parameter.Connection("data-source", dataSourceType, required = true)
  val generalGroup = ParameterGroup("general", List(dataSourceParameter, pathParameter, fileNameParameter, formatParameter))

  // Advanced
  val encryptionParameter = Parameter.String("encryption", options = List(
    ("none", ParameterValue.String("none")),
    ("aes256", ParameterValue.String("AES256"))
  ))
  val advancedGroup = ParameterGroup("advanced", List(encryptionParameter))

  val parameterGroups = List(generalGroup, advancedGroup, logGroup)

}