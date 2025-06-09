package com.harana.sdk.shared.models.common

import io.circe.{Decoder, Encoder, Json, HCursor}

type ParameterValues = Map[ParameterName, ParameterValue]

object ParameterValues:

  def empty: ParameterValues = Map.empty

  def apply(pairs: (Parameter, ParameterValue)*): ParameterValues =
    pairs.map((parameter, value) => parameter.name -> value).toMap

  given Encoder[Any] =
    case b: Boolean => Encoder.encodeBoolean(b)
    case d: Double => Encoder.encodeDouble(d)
    case s: String => Encoder.encodeString(s)
    case i: Int => Encoder.encodeInt(i)
    case l: Long => Encoder.encodeLong(l)
    case f: Float => Encoder.encodeFloat(f)
    case bd: BigDecimal => Encoder.encodeBigDecimal(bd)
    case bi: BigInt => Encoder.encodeBigInt(bi)
    case b: Byte => Encoder.encodeByte(b)
    case s: Short => Encoder.encodeShort(s)
    case c: Char => Encoder.encodeChar(c)
    case uuid: java.util.UUID => Encoder.encodeUUID(uuid)
    case uri: java.net.URI => Encoder.encodeURI(uri)
    case ji: java.lang.Integer => Encoder.encodeJavaInteger(ji)
    case u: Unit => Encoder.encodeUnit(u)
    case other => Encoder.encodeString(other.toString)


  given Decoder[Any] = (c: HCursor) =>
    for
      valueType <- c.downField("type").as[String]
      value <- c.downField("value").as[Json]
    yield
      valueType match
        case "Boolean" => Decoder.decodeBoolean.decodeJson(value).toOption.get
        case "Double" => Decoder.decodeDouble.decodeJson(value).toOption.get
        case "Int" => Decoder.decodeInt.decodeJson(value).toOption.get
        case "Float" => Decoder.decodeFloat.decodeJson(value).toOption.get
        case "Long" => Decoder.decodeLong.decodeJson(value).toOption.get
        case "BigDecimal" => Decoder.decodeBigDecimal.decodeJson(value).toOption.get
        case "BigInt" => Decoder.decodeBigInt.decodeJson(value).toOption.get
        case "Byte" => Decoder.decodeByte.decodeJson(value).toOption.get
        case "Short" => Decoder.decodeShort.decodeJson(value).toOption.get
        case "Char" => Decoder.decodeChar.decodeJson(value).toOption.get
        case "UUID" => Decoder.decodeUUID.decodeJson(value).toOption.get
        case "URI" => Decoder.decodeURI.decodeJson(value).toOption.get
        case "JavaInteger" => Decoder.decodeJavaInteger.decodeJson(value).toOption.get
        case "Unit" => Decoder.decodeUnit.decodeJson(value).toOption.get
        case "String" => Decoder.decodeString.decodeJson(value).toOption.get

  extension (values: ParameterValues)
    def get(parameter: Parameter)(using Decoder[parameter.ValueType]): parameter.ValueType =
      values.get(parameter.name).map(_.asInstanceOf[parameter.ValueType]).getOrElse(parameter.default)


