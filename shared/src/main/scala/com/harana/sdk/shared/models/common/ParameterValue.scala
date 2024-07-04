package com.harana.sdk.shared.models.common

import com.harana.sdk.shared.models.catalog.Page
import com.harana.sdk.shared.models.data.Connection
import io.circe.generic.JsonCodec

import java.{lang, net, time}
import scala.language.implicitConversions
//import scala.scalajs.reflect.annotation.EnableReflectiveInstantiation

sealed trait ParameterValue extends Any

object ParameterValue {

	@JsonCodec
	case class Boolean(value: scala.Boolean) extends AnyVal with ParameterValue

	@JsonCodec
	case class ConnectionId(value: Connection.ConnectionId) extends AnyVal with ParameterValue

	@JsonCodec
	case class Decimal(value: BigDecimal) extends AnyVal with ParameterValue

	@JsonCodec
	case class DecimalRange(value: (BigDecimal, BigDecimal)) extends AnyVal with ParameterValue

	@JsonCodec
	case class GeoAddress(value: GeoAddress) extends ParameterValue

	@JsonCodec
	case class GeoCoordinate(value: (java.lang.Double, java.lang.Double)) extends AnyVal with ParameterValue

	@JsonCodec
	case class Instant(value: java.time.Instant) extends AnyVal with ParameterValue

	@JsonCodec
	case class InstantRange(value: (java.time.Instant, java.time.Instant)) extends AnyVal with ParameterValue

	@JsonCodec
	case class Integer(value: Int) extends AnyVal with ParameterValue

	@JsonCodec
	case class IntegerList(value: List[Int]) extends AnyVal with ParameterValue

	@JsonCodec
	case class IntegerRange(value: (Int, Int)) extends AnyVal with ParameterValue

	@JsonCodec
	case class IPAddress(value: (java.lang.String, scala.Long)) extends AnyVal with ParameterValue

	@JsonCodec
	case class IPAddressList(value: List[(java.lang.String, scala.Long)]) extends AnyVal with ParameterValue

	@JsonCodec
	case class Long(value: scala.Long) extends AnyVal with ParameterValue

	@JsonCodec
	case class LongList(value: List[scala.Long]) extends AnyVal with ParameterValue

	@JsonCodec
	case class LongRange(value: (scala.Long, scala.Long)) extends AnyVal with ParameterValue

	@JsonCodec
	case class Money(value: BigDecimal) extends AnyVal with ParameterValue

//	@JsonCodec
//	case class Object(value: List[ParameterValue]) extends AnyVal with ParameterValue
//	implicit def obj(o: Object) = o.value
//	implicit def optObj(x: Option[Object]) = x.map(_.value)

	@JsonCodec
	case class PageId(value: com.harana.sdk.shared.models.catalog.Page.PageId) extends AnyVal with ParameterValue

	@JsonCodec
	case class String(value: java.lang.String) extends AnyVal with ParameterValue

	@JsonCodec
	case class StringList(value: List[java.lang.String]) extends AnyVal with ParameterValue

	@JsonCodec
	case class StringMap(value: Map[java.lang.String, java.lang.String]) extends AnyVal with ParameterValue

	@JsonCodec
	case class URI(value: java.net.URI) extends AnyVal with ParameterValue

	@JsonCodec
	case class UserId(value: com.harana.sdk.shared.models.common.User.UserId) extends AnyVal with ParameterValue

	@JsonCodec
	case class VideoId(value: com.harana.sdk.shared.models.common.Video.VideoId) extends AnyVal with ParameterValue

}