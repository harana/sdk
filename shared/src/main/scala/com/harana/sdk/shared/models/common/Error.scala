package com.harana.sdk.shared.models.common



case class Error(userMessage: Option[String], retriable: Boolean = false) extends Serializable