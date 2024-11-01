package com.harana.sdk.shared.plugin

import com.harana.sdk.shared.models.common.Parameter
trait Service {

  def name: String
  
  def title: String

  def description: String

  def instanceParameters: List[Parameter[?]]

  def globalParameters: List[Parameter[?]]

  def onStartup(): Unit

  def onShutdown(): Unit

  def onAppContextChange(newContext: Map[String, ?]): Unit

  def onUserConfigure(newValues: Map[String, ?]): Unit

}

object Service {
	type ServiceId = String
}