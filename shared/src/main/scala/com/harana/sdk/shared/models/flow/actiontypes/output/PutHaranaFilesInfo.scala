package com.harana.sdk.shared.models.flow.actiontypes.output

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup, ParameterValue}
import com.harana.sdk.shared.models.data.ConnectionTypes
import com.harana.sdk.shared.models.flow.actiontypes._

class PutHaranaFilesInfo extends OutputActionTypeInfo {

  val id = "09BF675D-AB4D-4749-9FED-EC14EFE48556"

  val tags = Set("harana")
  val dataSourceType = ConnectionTypes.HaranaFiles

  // General
  val dataSourceParameter = Parameter.Connection("data-source", dataSourceType, required = true)
  val generalGroup = ParameterGroup("general", List(pathParameter, fileNameParameter, formatParameter))

  // Advanced
  val encryptionParameter = Parameter.String("encryption", options = List(
    ("none", ParameterValue.String("none")),
    ("aes256", ParameterValue.String("AES256"))
  ))
  val advancedGroup = ParameterGroup("advanced", List(encryptionParameter))

  val parameterGroups = List(generalGroup, advancedGroup, logGroup)

}