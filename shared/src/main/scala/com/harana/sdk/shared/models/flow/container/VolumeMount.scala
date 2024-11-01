package com.harana.sdk.shared.models.flow.container



case class VolumeMount(mountPath: Option[String] = None,
                       mountPropagation: Option[String] = None,
                       name: String,
                       readOnly: Option[Boolean] = None,
                       subPath: Option[String] = None,
                       subPathExpr: Option[String] = None)