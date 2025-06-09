package com.harana.sdk.shared.plugin

import com.harana.sdk.shared.models.common.{Layout, ParameterName, ParameterValues}
import com.harana.sdk.shared.plugin.PanelType.PanelTypeId
import io.circe.Json

trait PageType extends Service:
  def detailLayout[T](values: ParameterValues): Layout
  def listLayout[T](values: ParameterValues): Layout
  def linkedPanelTypes: Set[PanelTypeId] = Set.empty

object PageType:
  type PageTypeId = String