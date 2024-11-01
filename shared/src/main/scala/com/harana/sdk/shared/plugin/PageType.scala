package com.harana.sdk.shared.plugin

import com.harana.sdk.shared.models.common.{Layout, ParameterMap, ParameterName}
import com.harana.sdk.shared.plugin.PanelType.PanelTypeId

trait PageType extends Service {

  def detailLayout[T](parameterValues: Map[ParameterName, Any]): Layout

  def listLayout[T](parameterValues: Map[ParameterName, Any]): Layout

  def linkedPanelTypes: Set[PanelTypeId] = Set.empty

}

object PageType {
  type PageTypeId = String
}