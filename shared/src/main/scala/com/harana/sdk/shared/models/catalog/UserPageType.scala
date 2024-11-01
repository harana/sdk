package com.harana.sdk.shared.models.catalog

import com.harana.sdk.shared.models.catalog.UserPageType.UserPageTypeId
import com.harana.sdk.shared.models.common.Entity.EntityId
import com.harana.sdk.shared.models.common.ParameterName
import com.harana.sdk.shared.models.common.User.UserId
import com.harana.sdk.shared.models.common._
import com.harana.sdk.shared.plugin.PanelType.PanelTypeId
import com.harana.sdk.shared.utils.CirceCodecs._

import java.time.Instant


case class UserPageType(
                         name: String,
                         title: String,
                         description: String,
                         listLayout: Layout,
                         detailLayout: Layout,
                         override val instanceParameters: List[Parameter[?]],
                         override val globalParameters: List[Parameter[?]],
                         override val linkedPanelTypes: Set[PanelTypeId] = Set.empty,
                         createdBy: Option[UserId],
                         created: Instant,
                         updatedBy: Option[UserId],
                         updated: Instant,
                         id: UserPageTypeId,
                         status: Status,
                         version: Long,
                         tags: Set[String],
                         relationships: Map[String, EntityId])
    extends Entity with Serializable with com.harana.sdk.shared.plugin.PageType {

	def listLayout[T](parameterValues: Map[ParameterName, Any]) = listLayout
	def detailLayout[T](parameterValues: Map[ParameterName, Any]) = detailLayout

	def onStartup(): Unit = {}
	def onShutdown(): Unit = {}

	override def onAppContextChange(newContext: Map[String, ?]): Unit = {}
	override def onUserConfigure(newparameterValues: Map[ParameterName, Any]): Unit = {}

	type EntityType = UserPageType
}

object UserPageType {
	type UserPageTypeId = String
}