package com.harana.sdk.shared.models.features.chronon

import io.circe.generic.JsonCodec

@JsonCodec
case class MetaData(name: Option[String] = None,
                    online: Option[Boolean] = None,
                    production: Option[Boolean] = None,
                    customJson: Option[String] = None,
                    dependencies: Option[List[String]] = None,
                    tableProperties: Option[Map[String, String]] = None,
                    outputNamespace: Option[String] = None,
                    team: Option[String] = None,
                    modeToEnvMap: Option[Map[String, Map[String, String]]] = None,
                    consistencyCheck: Option[Boolean] = None,
                    samplePercent: Option[Double] = None,
                    offlineSchedule: Option[String] = None,
                    consistencySamplePercent: Option[Double] = None,
                    historicalBackfill: Option[Boolean] = None)
