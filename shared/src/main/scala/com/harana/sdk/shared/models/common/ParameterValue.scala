package com.harana.sdk.shared.models.common

import com.harana.sdk.shared.models.catalog.Page
import com.harana.sdk.shared.models.data.DataSource
import io.circe.generic.JsonCodec

import java.{lang, net, time}
import scala.language.implicitConversions
//import scala.scalajs.reflect.annotation.EnableReflectiveInstantiation

sealed trait ParameterValue extends Any

object ParameterValue {

	@JsonCodec
	case class Boolean(value: scala.Boolean) extends AnyVal with ParameterValue
	implicit def boolean(x: Boolean): scala.Boolean = x.value
	implicit def optBoolean(x: Option[Boolean]): Option[scala.Boolean] = x.map(_.value)

	@JsonCodec
	case class DataSourceId(value: DataSource.DataSourceId) extends AnyVal with ParameterValue
	implicit def dataSourceId(x: DataSourceId): DataSource.DataSourceId = x.value
	implicit def optDataSourceId(x: Option[DataSourceId]): Option[DataSource.DataSourceId] = x.map(_.value)

	@JsonCodec
	case class Decimal(value: BigDecimal) extends AnyVal with ParameterValue
	implicit def decimal(x: Decimal): BigDecimal = x.value
	implicit def optDecimal(x: Option[Decimal]): Option[BigDecimal] = x.map(_.value)

	@JsonCodec
	case class DecimalRange(value: (BigDecimal, BigDecimal)) extends AnyVal with ParameterValue
	implicit def decimalRange(x: DecimalRange): (BigDecimal, BigDecimal) = x.value
	implicit def optDecimalRange(x: Option[DecimalRange]): Option[(BigDecimal, BigDecimal)] = x.map(_.value)

	@JsonCodec
	case class GeoAddress(value: GeoAddress) extends ParameterValue
	implicit def geoAddress(x: GeoAddress): GeoAddress = x.value
	implicit def optGeoAddress(x: Option[GeoAddress]): Option[GeoAddress] = x.map(_.value)

	@JsonCodec
	case class GeoCoordinate(value: (java.lang.Double, java.lang.Double)) extends AnyVal with ParameterValue
	implicit def geoCoordinate(x: GeoCoordinate): (lang.Double, lang.Double) = x.value
	implicit def optGeoCoordinate(x: Option[GeoCoordinate]): Option[(lang.Double, lang.Double)] = x.map(_.value)

	@JsonCodec
	case class Instant(value: java.time.Instant) extends AnyVal with ParameterValue
	implicit def instant(x: Instant): time.Instant = x.value
	implicit def optInstant(x: Option[Instant]): Option[time.Instant] = x.map(_.value)

	@JsonCodec
	case class InstantRange(value: (java.time.Instant, java.time.Instant)) extends AnyVal with ParameterValue
	implicit def instantRange(x: InstantRange): (time.Instant, time.Instant) = x.value
	implicit def optInstantRange(x: Option[InstantRange]): Option[(time.Instant, time.Instant)] = x.map(_.value)

	@JsonCodec
	case class Integer(value: Int) extends AnyVal with ParameterValue
	implicit def integer(x: Integer): Int = x.value
	implicit def optInteger(x: Option[Integer]): Option[Int] = x.map(_.value)

	@JsonCodec
	case class IntegerList(value: List[Int]) extends AnyVal with ParameterValue
	implicit def integerList(x: IntegerList): Seq[Int] = x.value
	implicit def optIntegerList(x: Option[IntegerList]): Option[List[Int]] = x.map(_.value)

	@JsonCodec
	case class IntegerRange(value: (Int, Int)) extends AnyVal with ParameterValue
	implicit def integerRange(x: IntegerRange): (Int, Int) = x.value
	implicit def optIntegerRange(x: Option[IntegerRange]): Option[(Int, Int)] = x.map(_.value)

	@JsonCodec
	case class IPAddress(value: (java.lang.String, scala.Long)) extends AnyVal with ParameterValue
	implicit def ipAddress(x: IPAddress): (java.lang.String, scala.Long) = x.value
	implicit def optIPAddress(x: Option[IPAddress]): Option[(java.lang.String, scala.Long)] = x.map(_.value)

	@JsonCodec
	case class IPAddressList(value: List[(java.lang.String, scala.Long)]) extends AnyVal with ParameterValue
	implicit def ipAddressList(x: IPAddressList): Seq[(java.lang.String, scala.Long)] = x.value
	implicit def optIPAddressList(x: Option[IPAddressList]): Option[List[(java.lang.String, scala.Long)]] = x.map(_.value)

	@JsonCodec
	case class Long(value: scala.Long) extends AnyVal with ParameterValue
	implicit def long(x: Long): scala.Long = x.value
	implicit def optLong(x: Option[Long]): Option[scala.Long] = x.map(_.value)

	@JsonCodec
	case class LongList(value: List[scala.Long]) extends AnyVal with ParameterValue
	implicit def longList(x: LongList): Seq[scala.Long] = x.value
	implicit def optLongList(x: Option[LongList]): Option[List[scala.Long]] = x.map(_.value)

	@JsonCodec
	case class LongRange(value: (scala.Long, scala.Long)) extends AnyVal with ParameterValue
	implicit def longRange(x: LongRange): (scala.Long, scala.Long) = x.value
	implicit def optLongRange(x: Option[LongRange]): Option[(scala.Long, scala.Long)] = x.map(_.value)

	@JsonCodec
	case class Money(value: BigDecimal) extends AnyVal with ParameterValue
	implicit def money(x: Money): BigDecimal = x.value
	implicit def optMoney(x: Option[Money]): Option[BigDecimal] = x.map(_.value)

//	@JsonCodec
//	case class Object(value: List[ParameterValue]) extends AnyVal with ParameterValue
//	implicit def obj(o: Object) = o.value
//	implicit def optObj(x: Option[Object]) = x.map(_.value)

	@JsonCodec
	case class PageId(value: com.harana.sdk.shared.models.catalog.Page.PageId) extends AnyVal with ParameterValue
	implicit def pageId(x: PageId): Page.PageId = x.value
	implicit def optPageId(x: Option[PageId]): Option[Page.PageId] = x.map(_.value)

	@JsonCodec
	case class String(value: java.lang.String) extends AnyVal with ParameterValue
	implicit def string(x: String): lang.String = x.value
	implicit def optString(x: Option[String]): Option[Predef.String] = x.map(_.value)

	@JsonCodec
	case class StringList(value: List[java.lang.String]) extends AnyVal with ParameterValue
	implicit def stringList(x: StringList): Seq[java.lang.String] = x.value
	implicit def optStringList(x: Option[StringList]): Option[List[Predef.String]] = x.map(_.value)

	@JsonCodec
	case class StringMap(value: Map[java.lang.String, java.lang.String]) extends AnyVal with ParameterValue
	implicit def stringMap(x: StringMap): Map[Predef.String, Predef.String] = x.value
	implicit def optStringMap(x: Option[StringMap]): Option[Map[Predef.String, Predef.String]] = x.map(_.value)

	@JsonCodec
	case class URI(value: java.net.URI) extends AnyVal with ParameterValue
	implicit def uri(x: URI): net.URI = x.value
	implicit def optURI(x: Option[URI]): Option[net.URI] = x.map(_.value)

	@JsonCodec
	case class UserId(value: com.harana.sdk.shared.models.common.User.UserId) extends AnyVal with ParameterValue
	implicit def userId(x: UserId): User.UserId = x.value
	implicit def optUserId(x: Option[UserId]): Option[User.UserId] = x.map(_.value)

	@JsonCodec
	case class VideoId(value: com.harana.sdk.shared.models.common.Video.VideoId) extends AnyVal with ParameterValue
	implicit def videoId(x: VideoId): Video.VideoId = x.value
	implicit def optVideoId(x: Option[VideoId]): Option[Video.VideoId] = x.map(_.value)
}