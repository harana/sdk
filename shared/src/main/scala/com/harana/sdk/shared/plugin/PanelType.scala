package com.harana.sdk.shared.plugin

import com.harana.sdk.shared.models.common.{Component, ParameterMap, ParameterName}

trait PanelType extends Service {

  def scripts: List[String] = List.empty

  def stylesheets: List[String] = List.empty

  def userEditable: Boolean = true

  def layout(parameterValues: Map[ParameterName, Any]): List[Component]

  def layoutHasChanged: Boolean

  def allowUserRefresh: Boolean

}

object PanelType {
  type PanelTypeId = String
}