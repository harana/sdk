package com.harana.sdk.shared.models.data.connection_types

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup, ParameterValue}
import com.harana.sdk.shared.models.data.ConnectionType.ConnectionTypeId
import com.harana.sdk.shared.models.data.{ConnectionType, SyncDirection}

case class Airbyte(id: ConnectionTypeId,
                   name: String,
                   parameterGroups: List[ParameterGroup],
                   syncDirection: SyncDirection,
                   supportsIncremental: Boolean,
                   supportsDBT: Boolean,
                   supportsNormalization: Boolean) extends ConnectionType