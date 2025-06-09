package com.harana.sdk.shared.models.common

import io.circe.*

type ParameterValue = Json

object ParameterValue:
  given [A](using Encoder[A]): Encoder[List[A]] = Encoder.encodeList
  given [A](using Decoder[A]): Decoder[List[A]] = Decoder.decodeList
  given [A](using Encoder[A]): Encoder[Option[A]] = Encoder.encodeOption
  given [A](using Decoder[A]): Decoder[Option[A]] = Decoder.decodeOption
  given [A](using Encoder[A]): Encoder[Seq[A]] = Encoder.encodeSeq
  given [A](using Decoder[A]): Decoder[Seq[A]] = Decoder.decodeSeq
  given [A](using Encoder[A]): Encoder[Set[A]] = Encoder.encodeSet
  given [A](using Decoder[A]): Decoder[Set[A]] = Decoder.decodeSet
  given [A](using Encoder[A]): Encoder[Vector[A]] = Encoder.encodeVector
  given [A](using Decoder[A]): Decoder[Vector[A]] = Decoder.decodeVector

  given Conversion[ParameterValue, Boolean] = Decoder.decodeBoolean.decodeJson(_).toOption.get
  given Conversion[ParameterValue, Double] = Decoder.decodeDouble.decodeJson(_).toOption.get
  given Conversion[ParameterValue, String] = Decoder.decodeString.decodeJson(_).toOption.get
  given Conversion[ParameterValue, Int] = Decoder.decodeInt.decodeJson(_).toOption.get
  given Conversion[ParameterValue, Long] = Decoder.decodeLong.decodeJson(_).toOption.get
  given Conversion[ParameterValue, Float] = Decoder.decodeFloat.decodeJson(_).toOption.get
  given Conversion[ParameterValue, BigDecimal] = Decoder.decodeBigDecimal.decodeJson(_).toOption.get
  given Conversion[ParameterValue, BigInt] = Decoder.decodeBigInt.decodeJson(_).toOption.get
  given Conversion[ParameterValue, Byte] = Decoder.decodeByte.decodeJson(_).toOption.get
  given Conversion[ParameterValue, Short] = Decoder.decodeShort.decodeJson(_).toOption.get
  given Conversion[ParameterValue, Char] = Decoder.decodeChar.decodeJson(_).toOption.get
  given Conversion[ParameterValue, java.util.UUID] = Decoder.decodeUUID.decodeJson(_).toOption.get
  given Conversion[ParameterValue, java.net.URI] = Decoder.decodeURI.decodeJson(_).toOption.get
  given Conversion[ParameterValue, java.lang.Integer] = Decoder.decodeJavaInteger.decodeJson(_).toOption.get
  given Conversion[ParameterValue, Unit] = Decoder.decodeUnit.decodeJson(_).toOption.get

  given Conversion[Boolean, ParameterValue] = Encoder.encodeBoolean(_)
  given Conversion[Double, ParameterValue] = Encoder.encodeDouble(_)
  given Conversion[String, ParameterValue] = Encoder.encodeString(_)
  given Conversion[Int, ParameterValue] = Encoder.encodeInt(_)
  given Conversion[Long, ParameterValue] = Encoder.encodeLong(_)
  given Conversion[Float, ParameterValue] = Encoder.encodeFloat(_)
  given Conversion[BigDecimal, ParameterValue] = Encoder.encodeBigDecimal(_)
  given Conversion[BigInt, ParameterValue] = Encoder.encodeBigInt(_)
  given Conversion[Byte, ParameterValue] = Encoder.encodeByte(_)
  given Conversion[Short, ParameterValue] = Encoder.encodeShort(_)
  given Conversion[Char, ParameterValue] = Encoder.encodeChar(_)
  given Conversion[java.util.UUID, ParameterValue] = Encoder.encodeUUID(_)
  given Conversion[java.net.URI, ParameterValue] = Encoder.encodeURI(_)
  given Conversion[java.lang.Integer, ParameterValue] = Encoder.encodeJavaInteger(_)
  given Conversion[Unit, ParameterValue] = Encoder.encodeUnit(_)

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


  given Conversion[Any, ParameterValue] =
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

  extension (value: ParameterValue | Option[ParameterValue])
    def to[A](using Decoder[A]): Option[A] =
      value match
        case v: ParameterValue => v.as[A].toOption
        case v: Option[ParameterValue] => v.flatMap(_.as[A].toOption)

    def to[A](default: A)(using Decoder[A]): A =
      value match
        case v: ParameterValue => v.as[A].toOption.getOrElse(default)
        case v: Option[ParameterValue] => v.flatMap(_.as[A].toOption).getOrElse(default)