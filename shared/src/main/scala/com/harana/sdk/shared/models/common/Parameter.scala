package com.harana.sdk.shared.models.common

import com.harana.sdk.shared.models.common.{DateTimeStyle, ParameterValidator}
import com.harana.sdk.shared.models.data.ConnectionType
import org.latestbit.circe.adt.codec.JsonTaggedAdt

import java.lang.String as JString
import java.net.URI
import java.time.Instant
import io.circe.syntax.*

type ParameterName = JString

sealed trait Parameter derives JsonTaggedAdt.Codec:
  val name: ParameterName
  val default: ParameterValue
  val required: scala.Boolean
  val validators: List[ParameterValidator]
  type ValueType

object Parameter:

  val title = Parameter.String("title")
  val description = Parameter.String("description")
  val tags = Parameter.StringList("tags")

  case class Boolean(name: ParameterName,
                     default: ParameterValue = false.asJson,
                     required: scala.Boolean = false,
                     validators: List[ParameterValidator] = List()) extends Parameter: 
    type ValueType = String

  case class Code(name: ParameterName,
                  default: ParameterValue = "".asJson,
                  required: scala.Boolean = false,
                  validators: List[ParameterValidator] = List()) extends Parameter: 
    type ValueType = String

  case class Color(name: ParameterName,
                   default: ParameterValue = "".asJson,
                   required: scala.Boolean = false,
                   validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = String
  
  case class Connection(name: ParameterName,
                        connectionType: ConnectionType,
                        default: ParameterValue = "".asJson,
                        required: scala.Boolean = false,
                        validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = String

  case class Country(name: ParameterName,
                     default: ParameterValue = "".asJson,
                     required: scala.Boolean = false,
                     validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = String

  case class DataTable(name: ParameterName,
                       default: ParameterValue = "".asJson,
                       required: scala.Boolean = false,
                       validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = String

  case class Date(name: ParameterName,
                  default: ParameterValue = Instant.now.asJson,
                  required: scala.Boolean = false,
                  validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = String

  case class DateRange(name: ParameterName,
                       default: ParameterValue = (Instant.now, Instant.now).asJson,
                       required: scala.Boolean = false,
                       validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = String

  case class DateTime(name: ParameterName,
                      default: ParameterValue = Instant.now.asJson,
                      required: scala.Boolean = false,
                      dateStyle: DateTimeStyle = DateTimeStyle.Short,
                      timeStyle: DateTimeStyle = DateTimeStyle.Short,
                      dateOptions: List[Instant] = List(),
                      validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = String

  case class Decimal(name: ParameterName,
                     default: ParameterValue = 0.0.asJson,
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
    type ValueType = String

  case class DecimalRange(name: ParameterName,
                          default: ParameterValue = (0.0, 0.0).asJson,
                          required: scala.Boolean = false,
                          minimumValue: BigDecimal = 0,
                          maximumValue: BigDecimal = 100,
                          validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = String

  case class Email(name: ParameterName,
                   default: ParameterValue = "".asJson,
                   required: scala.Boolean = false,
                   pattern: Option[JString] = None,
                   validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = String

  case class Emoji(name: ParameterName,
                   default: ParameterValue = "".asJson,
                   required: scala.Boolean = false,
                   validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = String

  case class File(name: ParameterName,
                  default: ParameterValue = "".asJson,
                  required: scala.Boolean = false,
                  allowDirectories: scala.Boolean = false,
                  allowFiles: scala.Boolean = true,
                  validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = String

  case class GeoAddress(name: ParameterName,
                        default: ParameterValue = "".asJson,
                        required: scala.Boolean = false,
                        validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = String

  case class GeoCoordinate(name: ParameterName,
                           default: ParameterValue = (0.0, 0.0).asJson,
                           required: scala.Boolean = false,
                           validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = String

  case class GeoLocation(name: ParameterName,
                         default: ParameterValue = (0.0, 0.0).asJson,
                         required: scala.Boolean = false,
                         validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = String

  case class Html(name: ParameterName,
                  default: ParameterValue = "".asJson,
                  required: scala.Boolean = false,
                  validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = String

  case class Image(name: ParameterName,
                   default: ParameterValue = "".asJson,
                   required: scala.Boolean = false,
                   validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = String

  case class Integer(name: ParameterName,
                     default: ParameterValue = 0.asJson,
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
                          default: ParameterValue = (0, 0).asJson,
                          required: scala.Boolean = false,
                          minimumValue: Int = 0,
                          maximumValue: Int = 100,
                          validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = (Int, Int)

  case class IPAddress(name: ParameterName,
                       default: ParameterValue = "".asJson,
                       required: scala.Boolean = false,
                       port: scala.Boolean = false,
                       portDefault: Option[scala.Long] = None,
                       options: List[(JString, JString)] = List(),
                       validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = String

  case class IPAddressList(name: ParameterName,
                           default: ParameterValue = List[JString]().asJson,
                           required: scala.Boolean = false,
                           port: scala.Boolean = false,
                           portDefault: Option[Int] = None,
                           options: List[(JString, List[JString])] = List(),
                           validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = String

  case class Json(name: ParameterName,
                  default: ParameterValue = "".asJson,
                  required: scala.Boolean = false,
                  validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = String

  case class Long(name: ParameterName,
                  default: ParameterValue = 0.asJson,
                  required: scala.Boolean = false,
                  options: List[(JString, scala.Long)] = List(),
                  maxLength: Option[Int] = None,
                  placeholder: Option[Int] = None,
                  thousandSeparator: Option[JString] = None,
                  allowNegative: Option[scala.Boolean] = None,
                  allowPositive: Option[scala.Boolean] = None,
                  pattern: Option[JString] = None,
                  validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = Long

  case class LongRange(name: ParameterName,
                       default: ParameterValue = (0, 0).asJson,
                       required: scala.Boolean = false,
                       minimumValue: scala.Long = 0,
                       maximumValue: scala.Long = 100,
                       validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = (Long, Long)

  case class Markdown(name: ParameterName,
                      default: ParameterValue = "".asJson,
                      required: scala.Boolean = false,
                      validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = String

  case class Money(name: ParameterName,
                   default: ParameterValue = 0.0.asJson,
                   required: scala.Boolean = false,
                   options: List[BigDecimal] = List(),
                   validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = String

  case class NewPassword(name: ParameterName,
                         default: ParameterValue = "".asJson,
                         required: scala.Boolean = false,
                         validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = String

  case class Password(name: ParameterName,
                      default: ParameterValue = "".asJson,
                      required: scala.Boolean = false,
                      validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = String

  case class SearchQuery(name: ParameterName,
                         default: ParameterValue = "".asJson,
                         required: scala.Boolean = false,
                         validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = String

  case class String(name: ParameterName,
                    default: ParameterValue = "".asJson,
                    required: scala.Boolean = false,
                    options: List[(JString, JString)] = List(),
                    placeholder: Option[JString] = None,
                    maxLength: Option[Int] = None,
                    multiLine: scala.Boolean = false,
                    inputFormat: Option[JString] = None,
                    pattern: Option[JString] = None,
                    validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = String

  case class StringList(name: ParameterName,
                        default: ParameterValue = List.empty[JString].asJson,
                        required: scala.Boolean = false,
                        options: List[(JString, List[JString])] = List(),
                        maxLength: Option[Int] = None,
                        multiLine: scala.Boolean = false,
                        inputFormat: Option[JString] = None,
                        pattern: Option[JString] = None,
                        validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = String

  case class Time(name: ParameterName,
                  default: ParameterValue = Instant.now.asJson,
                  required: scala.Boolean = false,
                  validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = String

  case class TimeZone(name: ParameterName,
                      default: ParameterValue = "".asJson,
                      required: scala.Boolean = false,
                      validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = String

  case class Uri(name: ParameterName,
                 default: ParameterValue = URI.create("https://").asJson,
                 required: scala.Boolean = false,
                 pattern: Option[JString] = None,
                 validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = URI

  case class User(name: ParameterName,
                  default: ParameterValue = "".asJson,
                  required: scala.Boolean = false,
                  validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = String

  case class Video(name: ParameterName,
                   default: ParameterValue = "".asJson,
                   required: scala.Boolean = false,
                   validators: List[ParameterValidator] = List()) extends Parameter:
    type ValueType = String
