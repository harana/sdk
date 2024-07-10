package com.harana.sdk.shared.models

import io.circe.{Decoder, Encoder}
import io.circe.derivation.{deriveDecoder, deriveEncoder}
import io.circe.syntax._

package object common {

  implicit val decodeParameterValue: Decoder[ParameterValue] = Decoder.instance[ParameterValue] { c =>
    val value = c.downField("value").success.get
    c.downField("type").as[String].getOrElse(throw new Exception("Parameter value type not found")) match {
      case "Boolean" => deriveDecoder[ParameterValue.Boolean].apply(value)
      case "Connection" => deriveDecoder[ParameterValue.ConnectionId].apply(value)
      case "Decimal" => deriveDecoder[ParameterValue.Decimal].apply(value)
      case "DecimalRange" => deriveDecoder[ParameterValue.DecimalRange].apply(value)
      case "GeoCoordinate" => deriveDecoder[ParameterValue.GeoCoordinate].apply(value)
      case "Instant" => deriveDecoder[ParameterValue.Instant].apply(value)
      case "InstantRange" => deriveDecoder[ParameterValue.InstantRange].apply(value)
      case "Integer" => deriveDecoder[ParameterValue.Integer].apply(value)
      case "IntegerList" => deriveDecoder[ParameterValue.IntegerList].apply(value)
      case "IntegerRange" => deriveDecoder[ParameterValue.IntegerRange].apply(value)
      case "IPAddress" => deriveDecoder[ParameterValue.IPAddress].apply(value)
      case "IPAddressList" => deriveDecoder[ParameterValue.IPAddressList].apply(value)
      case "Money" => deriveDecoder[ParameterValue.Money].apply(value)
      //			case "Object" => deriveDecoder[ParameterValue.Object].apply(value)
      case "PageId" => deriveDecoder[ParameterValue.PageId].apply(value)
      case "String" => deriveDecoder[ParameterValue.String].apply(value)
      case "StringList" => deriveDecoder[ParameterValue.StringList].apply(value)
      case "URI" => deriveDecoder[ParameterValue.URI].apply(value)
      case "UserId" => deriveDecoder[ParameterValue.UserId].apply(value)
      case "VideoId" => deriveDecoder[ParameterValue.VideoId].apply(value)
    }
  }

  implicit val encodeParameterValue: Encoder[ParameterValue] = Encoder.instance[ParameterValue] { parameter =>
    val parameterType = parameter.getClass.getSimpleName
    val json = parameterType match {
      case "Boolean" => deriveEncoder[ParameterValue.Boolean].apply(parameter.asInstanceOf[ParameterValue.Boolean])
      case "Connection" => deriveEncoder[ParameterValue.ConnectionId].apply(parameter.asInstanceOf[ParameterValue.ConnectionId])
      case "Decimal" => deriveEncoder[ParameterValue.Decimal].apply(parameter.asInstanceOf[ParameterValue.Decimal])
      case "DecimalRange" => deriveEncoder[ParameterValue.DecimalRange].apply(parameter.asInstanceOf[ParameterValue.DecimalRange])
      case "GeoCoordinate" => deriveEncoder[ParameterValue.GeoCoordinate].apply(parameter.asInstanceOf[ParameterValue.GeoCoordinate])
      case "Instant" => deriveEncoder[ParameterValue.Instant].apply(parameter.asInstanceOf[ParameterValue.Instant])
      case "InstantRange" => deriveEncoder[ParameterValue.InstantRange].apply(parameter.asInstanceOf[ParameterValue.InstantRange])
      case "Integer" => deriveEncoder[ParameterValue.Integer].apply(parameter.asInstanceOf[ParameterValue.Integer])
      case "IntegerList" => deriveEncoder[ParameterValue.IntegerList].apply(parameter.asInstanceOf[ParameterValue.IntegerList])
      case "IntegerRange" => deriveEncoder[ParameterValue.IntegerRange].apply(parameter.asInstanceOf[ParameterValue.IntegerRange])
      case "IPAddress" => deriveEncoder[ParameterValue.IPAddress].apply(parameter.asInstanceOf[ParameterValue.IPAddress])
      case "IPAddressList" => deriveEncoder[ParameterValue.IPAddressList].apply(parameter.asInstanceOf[ParameterValue.IPAddressList])
      case "Money" => deriveEncoder[ParameterValue.Money].apply(parameter.asInstanceOf[ParameterValue.Money])
      //			case "Object" => deriveEncoder[ParameterValue.Object].apply(parameter.asInstanceOf[ParameterValue.Object])
      case "PageId" => deriveEncoder[ParameterValue.PageId].apply(parameter.asInstanceOf[ParameterValue.PageId])
      case "String" => deriveEncoder[ParameterValue.String].apply(parameter.asInstanceOf[ParameterValue.String])
      case "StringList" => deriveEncoder[ParameterValue.StringList].apply(parameter.asInstanceOf[ParameterValue.StringList])
      case "URI" => deriveEncoder[ParameterValue.URI].apply(parameter.asInstanceOf[ParameterValue.URI])
      case "UserId" => deriveEncoder[ParameterValue.UserId].apply(parameter.asInstanceOf[ParameterValue.UserId])
      case "VideoId" => deriveEncoder[ParameterValue.VideoId].apply(parameter.asInstanceOf[ParameterValue.VideoId])
    }
    io.circe.Json.obj("type" -> parameterType.asJson, "value" -> json)
  }

  implicit val decodeParameterType: Decoder[Parameter] = Decoder.instance[Parameter] { c =>
    val content = c.downField("parameter").success.get
    c.downField("type").as[String].getOrElse(throw new Exception("Parameter type not found")) match {
      case "Boolean" => deriveDecoder[Parameter.Boolean].apply(content)
      case "Code" => deriveDecoder[Parameter.Code].apply(content)
      case "Color" => deriveDecoder[Parameter.Color].apply(content)
      case "Country" => deriveDecoder[Parameter.Country].apply(content)
      case "Connection" => deriveDecoder[Parameter.Connection].apply(content)
      case "DataTable" => deriveDecoder[Parameter.DataTable].apply(content)
      case "Date" => deriveDecoder[Parameter.Date].apply(content)
      case "Decimal" => deriveDecoder[Parameter.Decimal].apply(content)
      case "DecimalRange" => deriveDecoder[Parameter.DecimalRange].apply(content)
      case "Email" => deriveDecoder[Parameter.Email].apply(content)
      case "Emoji" => deriveDecoder[Parameter.Emoji].apply(content)
      case "File" => deriveDecoder[Parameter.File].apply(content)
      case "GeoCoordinate" => deriveDecoder[Parameter.GeoCoordinate].apply(content)
      case "Html" => deriveDecoder[Parameter.Html].apply(content)
      case "Image" => deriveDecoder[Parameter.Image].apply(content)
      case "Integer" => deriveDecoder[Parameter.Integer].apply(content)
      case "IntegerRange" => deriveDecoder[Parameter.IntegerRange].apply(content)
      case "IPAddress" => deriveDecoder[Parameter.IPAddress].apply(content)
      case "IPAddressList" => deriveDecoder[Parameter.IPAddressList].apply(content)
      case "Json" => deriveDecoder[Parameter.Json].apply(content)
      case "Markdown" => deriveDecoder[Parameter.Markdown].apply(content)
      case "Money" => deriveDecoder[Parameter.Money].apply(content)
      //			case "Object" => deriveDecoder[Parameter.Object].apply(content)
      case "Page" => deriveDecoder[Parameter.Page].apply(content)
      case "Password" => deriveDecoder[Parameter.Password].apply(content)
      case "SearchQuery" => deriveDecoder[Parameter.SearchQuery].apply(content)
      case "String" => deriveDecoder[Parameter.String].apply(content)
      case "StringList" => deriveDecoder[Parameter.StringList].apply(content)
      case "Time" => deriveDecoder[Parameter.Time].apply(content)
      case "TimeZone" => deriveDecoder[Parameter.TimeZone].apply(content)
      case "Uri" => deriveDecoder[Parameter.Uri].apply(content)
      case "User" => deriveDecoder[Parameter.User].apply(content)
      case "Video" => deriveDecoder[Parameter.Video].apply(content)
    }
  }

  implicit val encodeParameterType: Encoder[Parameter] = Encoder.instance[Parameter] { parameter =>
    val entityType = parameter.getClass.getSimpleName
    val json = entityType match {
      case "Boolean" => deriveEncoder[Parameter.Boolean].apply(parameter.asInstanceOf[Parameter.Boolean])
      case "Code" => deriveEncoder[Parameter.Code].apply(parameter.asInstanceOf[Parameter.Code])
      case "Color" => deriveEncoder[Parameter.Color].apply(parameter.asInstanceOf[Parameter.Color])
      case "Country" => deriveEncoder[Parameter.Country].apply(parameter.asInstanceOf[Parameter.Country])
      case "Connection" => deriveEncoder[Parameter.Connection].apply(parameter.asInstanceOf[Parameter.Connection])
      case "DataTable" => deriveEncoder[Parameter.DataTable].apply(parameter.asInstanceOf[Parameter.DataTable])
      case "Date" => deriveEncoder[Parameter.Date].apply(parameter.asInstanceOf[Parameter.Date])
      case "Decimal" => deriveEncoder[Parameter.Decimal].apply(parameter.asInstanceOf[Parameter.Decimal])
      case "DecimalRange" => deriveEncoder[Parameter.DecimalRange].apply(parameter.asInstanceOf[Parameter.DecimalRange])
      case "Email" => deriveEncoder[Parameter.Email].apply(parameter.asInstanceOf[Parameter.Email])
      case "Emoji" => deriveEncoder[Parameter.Emoji].apply(parameter.asInstanceOf[Parameter.Emoji])
      case "File" => deriveEncoder[Parameter.File].apply(parameter.asInstanceOf[Parameter.File])
      case "GeoCoordinate" => deriveEncoder[Parameter.GeoCoordinate].apply(parameter.asInstanceOf[Parameter.GeoCoordinate])
      case "Html" => deriveEncoder[Parameter.Html].apply(parameter.asInstanceOf[Parameter.Html])
      case "Image" => deriveEncoder[Parameter.Image].apply(parameter.asInstanceOf[Parameter.Image])
      case "Integer" => deriveEncoder[Parameter.Integer].apply(parameter.asInstanceOf[Parameter.Integer])
      case "IntegerRange" => deriveEncoder[Parameter.IntegerRange].apply(parameter.asInstanceOf[Parameter.IntegerRange])
      case "IPAddress" => deriveEncoder[Parameter.IPAddress].apply(parameter.asInstanceOf[Parameter.IPAddress])
      case "IPAddressList" => deriveEncoder[Parameter.IPAddressList].apply(parameter.asInstanceOf[Parameter.IPAddressList])
      case "Json" => deriveEncoder[Parameter.Json].apply(parameter.asInstanceOf[Parameter.Json])
      case "Markdown" => deriveEncoder[Parameter.Markdown].apply(parameter.asInstanceOf[Parameter.Markdown])
      case "Money" => deriveEncoder[Parameter.Money].apply(parameter.asInstanceOf[Parameter.Money])
      //			case "Object" => deriveEncoder[Parameter.Object].apply(parameter.asInstanceOf[Parameter.Object])
      case "Page" => deriveEncoder[Parameter.Page].apply(parameter.asInstanceOf[Parameter.Page])
      case "Password" => deriveEncoder[Parameter.Password].apply(parameter.asInstanceOf[Parameter.Password])
      case "SearchQuery" => deriveEncoder[Parameter.SearchQuery].apply(parameter.asInstanceOf[Parameter.SearchQuery])
      case "String" => deriveEncoder[Parameter.String].apply(parameter.asInstanceOf[Parameter.String])
      case "StringList" => deriveEncoder[Parameter.StringList].apply(parameter.asInstanceOf[Parameter.StringList])
      case "Time" => deriveEncoder[Parameter.Time].apply(parameter.asInstanceOf[Parameter.Time])
      case "TimeZone" => deriveEncoder[Parameter.TimeZone].apply(parameter.asInstanceOf[Parameter.TimeZone])
      case "Uri" => deriveEncoder[Parameter.Uri].apply(parameter.asInstanceOf[Parameter.Uri])
      case "User" => deriveEncoder[Parameter.User].apply(parameter.asInstanceOf[Parameter.User])
      case "Video" => deriveEncoder[Parameter.Video].apply(parameter.asInstanceOf[Parameter.Video])

    }
    io.circe.Json.obj("type" -> entityType.asJson, "parameter" -> json)
  }
}