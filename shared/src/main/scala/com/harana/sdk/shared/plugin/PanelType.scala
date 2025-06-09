package com.harana.sdk.shared.plugin

import com.harana.sdk.shared.models.common.{Component, ParameterName, ParameterValues}
import io.circe.Json

trait PanelType extends Service:
  def scripts: List[String] = List.empty
  def stylesheets: List[String] = List.empty
  def userEditable: Boolean = true
  def layout(values: ParameterValues): List[Component]
  def layoutHasChanged: Boolean
  def allowUserRefresh: Boolean

object PanelType:
  type PanelTypeId = String