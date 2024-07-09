package com.harana.sdk.shared.models.features.chronon

import io.circe.generic.JsonCodec

@JsonCodec
case class Join(metaData: Option[MetaData] = None,
                left: Option[Source] = None,
                joinParts: List[JoinPart],
                skewKeys: Option[Map[String, List[String]]] = None,
                onlineExternalParts: Option[List[ExternalPart]] = None,
                labelPart: Option[LabelPart] = None,
                bootstrapParts: Option[List[BootstrapPart]] = None,
                rowIds: Option[List[String]] = None,
                derivations: Option[List[Derivation]] = None)
