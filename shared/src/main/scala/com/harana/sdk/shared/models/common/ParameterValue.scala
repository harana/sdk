package com.harana.sdk.shared.models.common

type ParameterValue = Any

object ParameterValue:

  extension (value: ParameterValue)
    def to(parameter: Parameter): Option[parameter.ValueType] = value.asInstanceOf[parameter.ValueType]
