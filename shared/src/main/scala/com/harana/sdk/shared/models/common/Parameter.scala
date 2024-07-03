package com.harana.sdk.shared.models.common

import com.harana.sdk.shared.models.common.Parameter.ParameterName
import com.harana.sdk.shared.models.data.DataSourceType
import com.harana.sdk.shared.utils.HMap
import io.circe.generic.JsonCodec

import java.lang.{String => JString}
import java.time.Instant

sealed trait Parameter {
  type Value <: ParameterValue
  val name: ParameterName
  val default: Option[Value]
  val required: scala.Boolean
  val validators: List[ParameterValidator]
}

object Parameter {
  type ParameterName = java.lang.String
  type ParameterValues = HMap[ParametersMap]
  val ParameterValues = HMap[ParametersMap]

  class ParametersMap[Parameter, V]
  implicit val parameter: ParametersMap[Parameter, ParameterValue] = new ParametersMap[Parameter, ParameterValue]
  implicit def parameterValue[K <: Parameter]: ParametersMap[K, K#Value] = new ParametersMap[K, K#Value]

  implicit val boolean: ParametersMap[Boolean, ParameterValue.Boolean] = parameterValue[Boolean]
  implicit val code: ParametersMap[Code, ParameterValue.String] = parameterValue[Code]
  implicit val color: ParametersMap[Color, ParameterValue.String] = parameterValue[Color]
  implicit val country: ParametersMap[Country, ParameterValue.String] = parameterValue[Country]
  implicit val dataSource: ParametersMap[DataSource, ParameterValue.DataSourceId] = parameterValue[DataSource]
  implicit val dataTable: ParametersMap[DataTable, ParameterValue.String] = parameterValue[DataTable]
  implicit val date: ParametersMap[Date, ParameterValue.Instant] = parameterValue[Date]
  implicit val dateRange: ParametersMap[DateRange, ParameterValue.InstantRange] = parameterValue[DateRange]
  implicit val dateTime: ParametersMap[DateTime, ParameterValue.Instant] = parameterValue[DateTime]
  implicit val decimal: ParametersMap[Decimal, ParameterValue.Decimal] = parameterValue[Decimal]
  implicit val decimalRange: ParametersMap[DecimalRange, ParameterValue.DecimalRange] = parameterValue[DecimalRange]
  implicit val email: ParametersMap[Email, ParameterValue.String] = parameterValue[Email]
  implicit val emoji: ParametersMap[Emoji, ParameterValue.String] = parameterValue[Emoji]
  implicit val file: ParametersMap[File, ParameterValue.String] = parameterValue[File]
  implicit val geoAddress: ParametersMap[GeoAddress, ParameterValue.GeoAddress] = parameterValue[GeoAddress]
  implicit val geoCoordinate: ParametersMap[GeoCoordinate, ParameterValue.GeoCoordinate] = parameterValue[GeoCoordinate]
  implicit val geoLocation: ParametersMap[GeoLocation, ParameterValue.GeoCoordinate] = parameterValue[GeoLocation]
  implicit val html: ParametersMap[Html, ParameterValue.String] = parameterValue[Html]
  implicit val image: ParametersMap[Image, ParameterValue.String] = parameterValue[Image]
  implicit val integer: ParametersMap[Integer, ParameterValue.Integer] = parameterValue[Integer]
  implicit val integerRange: ParametersMap[IntegerRange, ParameterValue.IntegerRange] = parameterValue[IntegerRange]
  implicit val ipAddress: ParametersMap[IPAddress, ParameterValue.IPAddress] = parameterValue[IPAddress]
  implicit val ipAddressList: ParametersMap[IPAddressList, ParameterValue.IPAddressList] = parameterValue[IPAddressList]
  implicit val json: ParametersMap[Json, ParameterValue.String] = parameterValue[Json]
  implicit val long: ParametersMap[Long, ParameterValue.Long] = parameterValue[Long]
  implicit val longRange: ParametersMap[LongRange, ParameterValue.LongRange] = parameterValue[LongRange]
  implicit val markdown: ParametersMap[Markdown, ParameterValue.String] = parameterValue[Markdown]
  implicit val money: ParametersMap[Money, ParameterValue.Money] = parameterValue[Money]
  implicit val newPassword: ParametersMap[NewPassword, ParameterValue.String] = parameterValue[NewPassword]
//  implicit val obj = parameterValue[Object]
  implicit val page: ParametersMap[Page, ParameterValue.PageId] = parameterValue[Page]
  implicit val password: ParametersMap[Password, ParameterValue.String] = parameterValue[Password]
  implicit val searchQuery: ParametersMap[SearchQuery, ParameterValue.String] = parameterValue[SearchQuery]
  implicit val string: ParametersMap[String, ParameterValue.String] = parameterValue[String]
  implicit val stringList: ParametersMap[StringList, ParameterValue.StringList] = parameterValue[StringList]
  implicit val stringMap: ParametersMap[StringMap, ParameterValue.StringMap] = parameterValue[StringMap]
  implicit val tags: ParametersMap[Tags, ParameterValue.StringList] = parameterValue[Tags]
  implicit val time: ParametersMap[Time, ParameterValue.Instant] = parameterValue[Time]
  implicit val timeZone: ParametersMap[TimeZone, ParameterValue.String] = parameterValue[TimeZone]
  implicit val uri: ParametersMap[Uri, ParameterValue.URI] = parameterValue[Uri]
  implicit val user: ParametersMap[User, ParameterValue.UserId] = parameterValue[User]
  implicit val video: ParametersMap[Video, ParameterValue.VideoId] = parameterValue[Video]

  @JsonCodec
  case class Boolean(name: ParameterName,
                     default: Option[ParameterValue.Boolean] = None,
                     required: scala.Boolean = false,
                     validators: List[ParameterValidator] = List()) extends Parameter {
    type Value = ParameterValue.Boolean
  }

  @JsonCodec
  case class Code(name: ParameterName,
                  default: Option[ParameterValue.String] = None,
                  required: scala.Boolean = false,
                  validators: List[ParameterValidator] = List()) extends Parameter {
    type Value = ParameterValue.String
  }

  @JsonCodec
  case class Color(name: ParameterName,
                   default: Option[ParameterValue.String] = None,
                   required: scala.Boolean = false,
                   validators: List[ParameterValidator] = List()) extends Parameter {
    type Value = ParameterValue.String
  }

  @JsonCodec
  case class Country(name: ParameterName,
                     default: Option[ParameterValue.String] = None,
                     required: scala.Boolean = false,
                     validators: List[ParameterValidator] = List()) extends Parameter {
    type Value = ParameterValue.String
  }

  @JsonCodec
  case class DataTable(name: ParameterName,
                       default: Option[ParameterValue.String] = None,
                       required: scala.Boolean = false,
                       validators: List[ParameterValidator] = List()) extends Parameter {
    type Value = ParameterValue.String
  }

  @JsonCodec
  case class Date(name: ParameterName,
                  default: Option[ParameterValue.Instant] = None,
                  required: scala.Boolean = false,
                  validators: List[ParameterValidator] = List()) extends Parameter {
    type Value = ParameterValue.Instant
  }

  @JsonCodec
  case class DateRange(name: ParameterName,
                       default: Option[ParameterValue.InstantRange] = None,
                       required: scala.Boolean = false,
                       validators: List[ParameterValidator] = List()) extends Parameter {
    type Value = ParameterValue.InstantRange
  }

  @JsonCodec
  case class DataSource(name: ParameterName,
                        dataSourceType: DataSourceType,
                        default: Option[ParameterValue.DataSourceId] = None,
                        required: scala.Boolean = false,
                        validators: List[ParameterValidator] = List()) extends Parameter {
    type Value = ParameterValue.DataSourceId
  }

  @JsonCodec
  case class DateTime(name: ParameterName,
                      default: Option[ParameterValue.Instant] = None,
                      required: scala.Boolean = false,
                      dateOptions: List[Instant] = List(),
                      dateStyle: DateTimeStyle = DateTimeStyle.Short,
                      timeStyle: DateTimeStyle = DateTimeStyle.Short,
                      validators: List[ParameterValidator] = List()) extends Parameter {
    type Value = ParameterValue.Instant
  }

  @JsonCodec
  case class Decimal(name: ParameterName,
                     default: Option[ParameterValue.Decimal] = None,
                     required: scala.Boolean = false,
                     options: List[JString] = List(),
                     maxLength: Option[Int] = None,
                     placeholder: Option[JString] = None,
                     decimalSeparator: Option[JString] = None,
                     thousandSeparator: Option[JString] = None,
                     allowNegative: Option[scala.Boolean] = None,
                     allowPositive: Option[scala.Boolean] = None,
                     pattern: Option[JString] = None,
                     validators: List[ParameterValidator] = List()) extends Parameter {
    type Value = ParameterValue.Decimal
  }

  @JsonCodec
  case class DecimalRange(name: ParameterName,
                          default: Option[ParameterValue.DecimalRange] = None,
                          required: scala.Boolean = false,
                          minimumValue: BigDecimal = 0.0,
                          maximumValue: BigDecimal = 100.0,
                          validators: List[ParameterValidator] = List()) extends Parameter {
    type Value = ParameterValue.DecimalRange
  }

  @JsonCodec
  case class Email(name: ParameterName,
                   default: Option[ParameterValue.String] = None,
                   required: scala.Boolean = false,
                   pattern: Option[JString] = None,
                   validators: List[ParameterValidator] = List()) extends Parameter {
    type Value = ParameterValue.String
  }

  @JsonCodec
  case class Emoji(name: ParameterName,
                   default: Option[ParameterValue.String] = None,
                   required: scala.Boolean = false,
                   validators: List[ParameterValidator] = List()) extends Parameter {
    type Value = ParameterValue.String
  }

  @JsonCodec
  case class File(name: ParameterName,
                  default: Option[ParameterValue.String] = None,
                  required: scala.Boolean = false,
                  allowDirectories: scala.Boolean = false,
                  allowFiles: scala.Boolean = true,
                  validators: List[ParameterValidator] = List()) extends Parameter {
    type Value = ParameterValue.String
  }

  @JsonCodec
  case class GeoAddress(name: ParameterName,
                        default: Option[ParameterValue.GeoAddress] = None,
                        required:  scala.Boolean = false,
                        validators: List[ParameterValidator] = List()) extends Parameter {
    type Value = ParameterValue.GeoAddress
  }

  @JsonCodec
  case class GeoCoordinate(name: ParameterName,
                           default: Option[ParameterValue.GeoCoordinate] = None,
                           required: scala.Boolean = false,
                           validators: List[ParameterValidator] = List()) extends Parameter {
    type Value = ParameterValue.GeoCoordinate
  }

  @JsonCodec
  case class GeoLocation(name: ParameterName,
                         default: Option[ParameterValue.GeoCoordinate] = None,
                         required: scala.Boolean = false,
                         validators: List[ParameterValidator] = List()) extends Parameter {
    type Value = ParameterValue.GeoCoordinate
  }

  @JsonCodec
  case class Html(name: ParameterName,
                  default: Option[ParameterValue.String] = None,
                  required: scala.Boolean = false,
                  validators: List[ParameterValidator] = List()) extends Parameter {
    type Value = ParameterValue.String
  }

  @JsonCodec
  case class Image(name: ParameterName,
                   default: Option[ParameterValue.String] = None,
                   required: scala.Boolean = false,
                   validators: List[ParameterValidator] = List()) extends Parameter {
    type Value = ParameterValue.String
  }

  @JsonCodec
  case class Integer(name: ParameterName,
                     default: Option[ParameterValue.Integer] = None,
                     required: scala.Boolean = false,
                     options: List[(JString, ParameterValue.Integer)] = List(),
                     maxLength: Option[Int] = None,
                     placeholder: Option[Int] = None,
                     thousandSeparator: Option[JString] = None,
                     allowNegative: Option[scala.Boolean] = None,
                     allowPositive: Option[scala.Boolean] = None,
                     pattern: Option[JString] = None,
                     validators: List[ParameterValidator] = List()) extends Parameter {
    type Value = ParameterValue.Integer
  }

  @JsonCodec
  case class IntegerRange(name: ParameterName,
                          default: Option[ParameterValue.IntegerRange] = None,
                          required: scala.Boolean = false,
                          minimumValue: Int = 0,
                          maximumValue: Int = 100,
                          validators: List[ParameterValidator] = List()) extends Parameter {
    type Value = ParameterValue.IntegerRange
  }

  @JsonCodec
  case class IPAddress(name: ParameterName,
                       default: Option[ParameterValue.IPAddress] = None,
                       required: scala.Boolean = false,
                       port: scala.Boolean = false,
                       portDefault: Option[scala.Long] = None,
                       options: List[(JString, ParameterValue.IPAddress)] = List(),
                       validators: List[ParameterValidator] = List()) extends Parameter {
    type Value = ParameterValue.IPAddress
  }

  @JsonCodec
  case class IPAddressList(name: ParameterName,
                           default: Option[ParameterValue.IPAddressList] = None,
                           required: scala.Boolean = false,
                           port: scala.Boolean = false,
                           portDefault: Option[scala.Int] = None,
                           options: List[(JString, ParameterValue.IPAddressList)] = List(),
                           validators: List[ParameterValidator] = List()) extends Parameter {
    type Value = ParameterValue.IPAddressList
  }

  @JsonCodec
  case class Json(name: ParameterName,
                  default: Option[ParameterValue.String] = None,
                  required: scala.Boolean = false,
                  validators: List[ParameterValidator] = List()) extends Parameter {
    type Value = ParameterValue.String
  }

  @JsonCodec
  case class Long(name: ParameterName,
                  default: Option[ParameterValue.Long] = None,
                  required: scala.Boolean = false,
                  options: List[(JString, ParameterValue.Long)] = List(),
                  maxLength: Option[Int] = None,
                  placeholder: Option[Int] = None,
                  thousandSeparator: Option[JString] = None,
                  allowNegative: Option[scala.Boolean] = None,
                  allowPositive: Option[scala.Boolean] = None,
                  pattern: Option[JString] = None,
                  validators: List[ParameterValidator] = List()) extends Parameter {
    type Value = ParameterValue.Long
  }

  @JsonCodec
  case class LongRange(name: ParameterName,
                       default: Option[ParameterValue.LongRange] = None,
                       required: scala.Boolean = false,
                       minimumValue: Int = 0,
                       maximumValue: Int = 100,
                       validators: List[ParameterValidator] = List()) extends Parameter {
    type Value = ParameterValue.LongRange
  }

  @JsonCodec
  case class Markdown(name: ParameterName,
                      default: Option[ParameterValue.String] = None,
                      required: scala.Boolean = false,
                      validators: List[ParameterValidator] = List()) extends Parameter {
    type Value = ParameterValue.String
  }

  @JsonCodec
  case class Money(name: ParameterName,
                   default: Option[ParameterValue.Money] = None,
                   required: scala.Boolean = false,
                   options: List[Money] = List(),
                   validators: List[ParameterValidator] = List()) extends Parameter {
    type Value = ParameterValue.Money
  }

  @JsonCodec
  case class NewPassword(name: ParameterName,
                         default: Option[ParameterValue.String] = None,
                         required: scala.Boolean = false,
                         validators: List[ParameterValidator] = List()) extends Parameter {
    type Value = ParameterValue.String
  }

//  @JsonCodec
//  case class Object(name: ParameterName,
//                    default: Option[ParameterValue.Object] = None,
//                    required: scala.Boolean = false,
//                    options: List[(JString, List[Parameter])] = List(),
//                    validators: List[ParameterValidator] = List()) extends Parameter {
//    type Value = ParameterValue.Object
//  }

  @JsonCodec
  case class Page(name: ParameterName,
                  default: Option[ParameterValue.PageId] = None,
                  required: scala.Boolean = false,
                  validators: List[ParameterValidator] = List()) extends Parameter {
    type Value = ParameterValue.PageId
  }

  @JsonCodec
  case class Password(name: ParameterName,
                      default: Option[ParameterValue.String] = None,
                      required: scala.Boolean = false,
                      validators: List[ParameterValidator] = List()) extends Parameter {
    type Value = ParameterValue.String
  }

  @JsonCodec
  case class SearchQuery(name: ParameterName,
                         default: Option[ParameterValue.String] = None,
                         required: scala.Boolean = false,
                         validators: List[ParameterValidator] = List()) extends Parameter {
    type Value = ParameterValue.String
  }

  @JsonCodec
  case class String(name: ParameterName,
                    default: Option[ParameterValue.String] = None,
                    required: scala.Boolean = false,
                    options: List[(JString, JString)] = List(),
                    placeholder: Option[JString] = None,
                    maxLength: Option[Int] = None,
                    multiLine: scala.Boolean = false,
                    inputFormat: Option[JString] = None,
                    pattern: Option[JString] = None,
                    validators: List[ParameterValidator] = List()) extends Parameter {
    type Value = ParameterValue.String
  }

  @JsonCodec
  case class StringList(name: ParameterName,
                        default: Option[ParameterValue.StringList] = None,
                        required: scala.Boolean = false,
                        options: List[(JString, ParameterValue.StringList)] = List(),
                        maxLength: Option[Int] = None,
                        multiLine: scala.Boolean = false,
                        inputFormat: Option[JString] = None,
                        pattern: Option[JString] = None,
                        validators: List[ParameterValidator] = List()) extends Parameter {
    type Value = ParameterValue.StringList
  }

  @JsonCodec
  case class StringMap(name: ParameterName,
                       default: Option[ParameterValue.StringMap] = None,
                       required: scala.Boolean = false,
                       options: Map[JString, JString] = Map(),
                       inputFormat: Option[JString] = None,
                       pattern: Option[JString] = None,
                       validators: List[ParameterValidator] = List()) extends Parameter {
    type Value = ParameterValue.StringMap
  }

  @JsonCodec
  case class Tags(name: ParameterName,
                  default: Option[ParameterValue.StringList] = None,
                  required: scala.Boolean = false,
                  limit: Option[Int] = None,
                  allowDuplicates: scala.Boolean = true,
                  validators: List[ParameterValidator] = List()) extends Parameter {
    type Value = ParameterValue.StringList
  }

  @JsonCodec
  case class Time(name: ParameterName,
                  default: Option[ParameterValue.Instant] = None,
                  required: scala.Boolean = false,
                  validators: List[ParameterValidator] = List()) extends Parameter {
    type Value = ParameterValue.Instant
  }

  @JsonCodec
  case class TimeZone(name: ParameterName,
                      default: Option[ParameterValue.String] = None,
                      required: scala.Boolean = false,
                      validators: List[ParameterValidator] = List()) extends Parameter {
    type Value = ParameterValue.String
  }

  @JsonCodec
  case class Uri(name: ParameterName,
                 default: Option[ParameterValue.URI] = None,
                 required: scala.Boolean = false,
                 pattern: Option[JString] = None,
                 validators: List[ParameterValidator] = List()) extends Parameter {
    type Value = ParameterValue.URI
  }

  @JsonCodec
  case class User(name: ParameterName,
                  default: Option[ParameterValue.UserId] = None,
                  required: scala.Boolean = false,
                  validators: List[ParameterValidator] = List()) extends Parameter {
    type Value = ParameterValue.UserId
  }

  @JsonCodec
  case class Video(name: ParameterName,
                   default: Option[ParameterValue.VideoId] = None,
                   required: scala.Boolean = false,
                   validators: List[ParameterValidator] = List()) extends Parameter {
    type Value = ParameterValue.VideoId
  }
}