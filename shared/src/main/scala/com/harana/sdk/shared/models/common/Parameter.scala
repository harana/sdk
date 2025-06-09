package com.harana.sdk.shared.models.common

import com.harana.sdk.shared.models.common.{DateTimeStyle, ParameterValidator}
import com.harana.sdk.shared.models.data.ConnectionType
import org.latestbit.circe.adt.codec.JsonTaggedAdt

import java.lang.String as JString
import java.net.URI
import java.time.Instant
import io.circe.{Decoder, Encoder}
import io.circe.syntax.*

type ParameterName = JString

sealed trait Parameter derives JsonTaggedAdt.Codec:
  type ValueType: {Decoder, Encoder}
  val name: ParameterName
  val default: ValueType
  val required: scala.Boolean
  val validators: List[ParameterValidator]

object Parameter:
  val title = Parameter.String("title")
  val description = Parameter.String("description")
  val tags = Parameter.StringList("tags")

  case class Boolean(name: ParameterName,
                     default: scala.Boolean = false,
                     required: scala.Boolean = false,
                     validators: List[ParameterValidator] = List()) extends Parameter: 
    type ValueType = scala.Boolean

  case class Code(name: ParameterName,
                  default: JString = "",
                  required: scala.Boolean = false,
                  validators: List[ParameterValidator] = List()) extends Parameter: 
    type ValueType = JString

  case class Color(name: ParameterName,
                   default: JString = "",
                   required: scala.Boolean = false,
                   validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = JString
  
  case class Connection(name: ParameterName,
                        connectionType: ConnectionType,
                        default: JString = "",
                        required: scala.Boolean = false,
                        validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = JString

  case class Country(name: ParameterName,
                     default: JString = "",
                     required: scala.Boolean = false,
                     validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = JString

  case class DataTable(name: ParameterName,
                       default: JString = "",
                       required: scala.Boolean = false,
                       validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = JString

  case class Date(name: ParameterName,
                  default: Instant = Instant.now,
                  required: scala.Boolean = false,
                  validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = Instant

  case class DateRange(name: ParameterName,
                       default: (Instant, Instant) = (Instant.now, Instant.now),
                       required: scala.Boolean = false,
                       validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = (Instant, Instant)

  case class DateTime(name: ParameterName,
                      default: Instant = Instant.now,
                      required: scala.Boolean = false,
                      dateStyle: DateTimeStyle = DateTimeStyle.Short,
                      timeStyle: DateTimeStyle = DateTimeStyle.Short,
                      dateOptions: List[Instant] = List(),
                      validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = Instant

  case class Decimal(name: ParameterName,
                     default: BigDecimal = 0.0,
                     required: scala.Boolean = false,
                     options: List[JString] = List(),
                     maxLength: Option[Int] = None,
                     placeholder: Option[JString] = None,
                     decimalSeparator: Option[JString] = None,
                     thousandSeparator: Option[JString] = None,
                     allowNegative: Option[scala.Boolean] = None,
                     allowPositive: Option[scala.Boolean] = None,
                     pattern: Option[JString] = None,
                     validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = BigDecimal

  case class DecimalRange(name: ParameterName,
                          default: (BigDecimal, BigDecimal) = (0.0, 0.0),
                          required: scala.Boolean = false,
                          minimumValue: BigDecimal = 0,
                          maximumValue: BigDecimal = 100,
                          validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = (BigDecimal, BigDecimal)

  case class Email(name: ParameterName,
                   default: JString = "",
                   required: scala.Boolean = false,
                   pattern: Option[JString] = None,
                   validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = JString

  case class Emoji(name: ParameterName,
                   default: JString = "",
                   required: scala.Boolean = false,
                   validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = JString

  case class File(name: ParameterName,
                  default: JString = "",
                  required: scala.Boolean = false,
                  allowDirectories: scala.Boolean = false,
                  allowFiles: scala.Boolean = true,
                  validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = JString

  case class GeoAddress(name: ParameterName,
                        default: JString = "",
                        required: scala.Boolean = false,
                        validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = JString

  case class GeoCoordinate(name: ParameterName,
                           default: (Double, Double) = (0.0, 0.0),
                           required: scala.Boolean = false,
                           validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = (Double, Double)

  case class GeoLocation(name: ParameterName,
                         default: (Double, Double) = (0.0, 0.0),
                         required: scala.Boolean = false,
                         validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = (Double, Double)

  case class Html(name: ParameterName,
                  default: JString = "",
                  required: scala.Boolean = false,
                  validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = JString

  case class Image(name: ParameterName,
                   default: JString = "",
                   required: scala.Boolean = false,
                   validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = JString

  case class Integer(name: ParameterName,
                     default: Int = 0,
                     required: scala.Boolean = false,
                     options: List[(JString, Int)] = List(),
                     maxLength: Option[Int] = None,
                     placeholder: Option[Int] = None,
                     thousandSeparator: Option[JString] = None,
                     allowNegative: Option[scala.Boolean] = None,
                     allowPositive: Option[scala.Boolean] = None,
                     pattern: Option[JString] = None,
                     validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = Int

  case class IntegerRange(name: ParameterName,
                          default: (Int, Int) = (0, 0),
                          required: scala.Boolean = false,
                          minimumValue: Int = 0,
                          maximumValue: Int = 100,
                          validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = (Int, Int)

  case class IPAddress(name: ParameterName,
                       default: JString = "",
                       required: scala.Boolean = false,
                       port: scala.Boolean = false,
                       portDefault: Option[scala.Long] = None,
                       options: List[(JString, JString)] = List(),
                       validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = JString

  case class IPAddressList(name: ParameterName,
                           default: List[JString] = List.empty[JString],
                           required: scala.Boolean = false,
                           port: scala.Boolean = false,
                           portDefault: Option[Int] = None,
                           options: List[(JString, List[JString])] = List(),
                           validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = List[JString]

  case class Json(name: ParameterName,
                  default: JString = "",
                  required: scala.Boolean = false,
                  validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = JString

  case class Long(name: ParameterName,
                  default: scala.Long = 0L,
                  required: scala.Boolean = false,
                  options: List[(JString, scala.Long)] = List(),
                  maxLength: Option[Int] = None,
                  placeholder: Option[Int] = None,
                  thousandSeparator: Option[JString] = None,
                  allowNegative: Option[scala.Boolean] = None,
                  allowPositive: Option[scala.Boolean] = None,
                  pattern: Option[JString] = None,
                  validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = scala.Long

  case class LongRange(name: ParameterName,
                       default: (scala.Long, scala.Long) = (0L, 0L),
                       required: scala.Boolean = false,
                       minimumValue: scala.Long = 0,
                       maximumValue: scala.Long = 100,
                       validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = (scala.Long, scala.Long)

  case class Markdown(name: ParameterName,
                      default: JString = "",
                      required: scala.Boolean = false,
                      validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = JString

  case class Money(name: ParameterName,
                   default: Double = 0.0,
                   required: scala.Boolean = false,
                   options: List[BigDecimal] = List(),
                   validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = Double

  case class NewPassword(name: ParameterName,
                         default: JString = "",
                         required: scala.Boolean = false,
                         validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = JString

  case class Password(name: ParameterName,
                      default: JString = "",
                      required: scala.Boolean = false,
                      validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = JString

  case class SearchQuery(name: ParameterName,
                         default: JString = "",
                         required: scala.Boolean = false,
                         validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = JString

  case class String(name: ParameterName,
                    default: JString = "",
                    required: scala.Boolean = false,
                    options: List[(JString, JString)] = List(),
                    placeholder: Option[JString] = None,
                    maxLength: Option[Int] = None,
                    multiLine: scala.Boolean = false,
                    inputFormat: Option[JString] = None,
                    pattern: Option[JString] = None,
                    validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = JString

  case class StringList(name: ParameterName,
                        default: List[JString] = List.empty[JString],
                        required: scala.Boolean = false,
                        options: List[(JString, List[JString])] = List(),
                        maxLength: Option[Int] = None,
                        multiLine: scala.Boolean = false,
                        inputFormat: Option[JString] = None,
                        pattern: Option[JString] = None,
                        validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = List[JString]

  case class Time(name: ParameterName,
                  default: Instant = Instant.now,
                  required: scala.Boolean = false,
                  validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = Instant

  case class TimeZone(name: ParameterName,
                      default: JString = "",
                      required: scala.Boolean = false,
                      validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = JString

  case class Uri(name: ParameterName,
                 default: URI = URI.create("https://"),
                 required: scala.Boolean = false,
                 pattern: Option[JString] = None,
                 validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = URI

  case class User(name: ParameterName,
                  default: JString = "",
                  required: scala.Boolean = false,
                  validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = JString

  case class Video(name: ParameterName,
                   default: JString = "",
                   required: scala.Boolean = false,
                   validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = JString
