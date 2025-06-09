package com.harana.sdk.shared.models.common

import io.circe.{Decoder, Encoder, Json}

type ParameterValues = Map[ParameterName, ParameterValue]

object ParameterValues:

  def empty: ParameterValues = Map.empty

  def apply[T: Encoder](pairs: (Parameter, T)*): ParameterValues =
    pairs.map((parameter, value) => parameter.name -> Encoder[T].apply(value)).toMap

  extension (values: ParameterValues)

    def getWithDefault[T: Decoder](parameter: Parameter): T =
      values.get(parameter.name).flatMap(_.as[T].toOption).getOrElse(parameter.default.as[T].toOption.get)

    def put[T: Encoder](parameter: Parameter, value: T): ParameterValues =
      values + (parameter.name -> Encoder[T].apply(value))

    def putAll[T: Encoder](pairs: (Parameter, T)*): ParameterValues =
      values ++ pairs.map((parameter, value) => parameter.name -> Encoder[T].apply(value))

    def +[T: Encoder](pair: (Parameter, T)): ParameterValues =
      put(pair._1, pair._2)

    def ++[T: Encoder](pairs: Iterable[(Parameter, T)]): ParameterValues =
      values ++ pairs.map((parameter, value) => parameter.name -> Encoder[T].apply(value))