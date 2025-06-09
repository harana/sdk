package com.harana.sdk.shared.plugin

import com.harana.sdk.shared.models.common.{Parameter, ParameterValues}

trait Service:
  def name: String
  def title: String
  def description: String
  def instanceParameters: List[Parameter]
  def globalParameters: List[Parameter]
  def onStartup(): Unit
  def onShutdown(): Unit
  def onAppContextChange(newContext: Map[String, ?]): Unit
  def onUserConfigure(newValues: ParameterValues): Unit

object Service:
	type ServiceId = String