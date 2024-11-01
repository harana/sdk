package com.harana.sdk.shared.models.common



case class HelpCategory(name: String, pages: List[HelpPage])


case class HelpPage(name: String, icon: Option[String], path: String)