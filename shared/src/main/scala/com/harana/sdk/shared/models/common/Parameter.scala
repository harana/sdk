package com.harana.sdk.shared.models.common

import com.harana.sdk.shared.utils.CirceCodecs.*
import com.harana.sdk.shared.models.common.{DateTimeStyle, ParameterValidator}
import com.harana.sdk.shared.models.data.ConnectionType
import org.latestbit.circe.adt.codec.JsonTaggedAdt

import java.net.URI
import java.time.Instant
import scala.collection.mutable
import java.lang.String as JString

type ParameterName = JString

enum ParameterType[A](name: ParameterName, 
                      default: Option[A],
                      required: scala.Boolean,
                      validators: List[ParameterValidator]) derives JsonTaggedAdt.Decoder, JsonTaggedAdt.Encoder:

  case Boolean(name: ParameterName,
               default: Option[scala.Boolean] = None,
               required: scala.Boolean = false,
               validators: List[ParameterValidator] = List()) extends ParameterType[scala.Boolean](name, default, required, validators)

  case Code(name: ParameterName,
            default: Option[JString] = None,
            required: scala.Boolean = false,
            validators: List[ParameterValidator] = List()) extends ParameterType[JString](name, default, required, validators)

  case Color(name: ParameterName,
             default: Option[JString] = None,
             required: scala.Boolean = false,
             validators: List[ParameterValidator] = List()) extends ParameterType[JString](name, default, required, validators)

  case Connection(name: ParameterName,
                  connectionType: ConnectionType,
                  default: Option[JString] = None,
                  required: scala.Boolean = false,
                  validators: List[ParameterValidator] = List()) extends ParameterType[JString](name, default, required, validators)

  case Country(name: ParameterName,
               default: Option[JString] = None,
               required: scala.Boolean = false,
               validators: List[ParameterValidator] = List()) extends ParameterType[JString](name, default, required, validators)

  case DataTable(name: ParameterName,
                 default: Option[JString] = None,
                 required: scala.Boolean = false,
                 validators: List[ParameterValidator] = List()) extends ParameterType[JString](name, default, required, validators)

  case Date(name: ParameterName,
            default: Option[Instant] = None,
            required: scala.Boolean = false,
            validators: List[ParameterValidator] = List()) extends ParameterType[Instant](name, default, required, validators)

  case DateRange(name: ParameterName,
                 default: Option[(Instant, Instant)] = None,
                 required: scala.Boolean = false,
                 validators: List[ParameterValidator] = List()) extends ParameterType[(Instant, Instant)](name, default, required, validators)

  case DateTime(name: ParameterName,
                default: Option[Instant] = None,
                required: scala.Boolean = false,
                dateStyle: DateTimeStyle = DateTimeStyle.Short,
                timeStyle: DateTimeStyle = DateTimeStyle.Short,
                dateOptions: List[Instant] = List(),
                validators: List[ParameterValidator] = List()) extends ParameterType[Instant](name, default, required, validators)

  case Decimal(name: ParameterName,
               default: Option[BigDecimal] = None,
               required: scala.Boolean = false,
               options: List[JString] = List(),
               maxLength: Option[Int] = None,
               placeholder: Option[JString] = None,
               decimalSeparator: Option[JString] = None,
               thousandSeparator: Option[JString] = None,
               allowNegative: Option[scala.Boolean] = None,
               allowPositive: Option[scala.Boolean] = None,
               pattern: Option[JString] = None,
               validators: List[ParameterValidator] = List()) extends ParameterType[BigDecimal](name, default, required, validators)

  case DecimalRange(name: ParameterName,
                    default: Option[(BigDecimal, BigDecimal)] = None,
                    required: scala.Boolean = false,
                    minimumValue: BigDecimal = 0,
                    maximumValue: BigDecimal = 100,
                    validators: List[ParameterValidator] = List()) extends ParameterType[(BigDecimal, BigDecimal)](name, default, required, validators)

  case Email(name: ParameterName,
             default: Option[JString] = None,
             required: scala.Boolean = false,
             pattern: Option[JString] = None,
             validators: List[ParameterValidator] = List()) extends ParameterType[JString](name, default, required, validators)

  case Emoji(name: ParameterName,
             default: Option[JString] = None,
             required: scala.Boolean = false,
             validators: List[ParameterValidator] = List()) extends ParameterType[JString](name, default, required, validators)

  case File(name: ParameterName,
            default: Option[JString] = None,
            required: scala.Boolean = false,
            allowDirectories: scala.Boolean = false,
            allowFiles: scala.Boolean = true,
            validators: List[ParameterValidator] = List()) extends ParameterType[JString](name, default, required, validators)

  case GeoAddress(name: ParameterName,
                  default: Option[JString] = None,
                  required: scala.Boolean = false,
                  validators: List[ParameterValidator] = List()) extends ParameterType[JString](name, default, required, validators)

  case GeoCoordinate(name: ParameterName,
                     default: Option[(Double, Double)] = None,
                     required: scala.Boolean = false,
                     validators: List[ParameterValidator] = List()) extends ParameterType[(Double, Double)](name, default, required, validators)

  case GeoLocation(name: ParameterName,
                   default: Option[(Double, Double)] = None,
                   required: scala.Boolean = false,
                   validators: List[ParameterValidator] = List()) extends ParameterType[(Double, Double)](name, default, required, validators)

  case Html(name: ParameterName,
            default: Option[JString] = None,
            required: scala.Boolean = false,
            validators: List[ParameterValidator] = List()) extends ParameterType[JString](name, default, required, validators)

  case Image(name: ParameterName,
             default: Option[JString] = None,
             required: scala.Boolean = false,
             validators: List[ParameterValidator] = List()) extends ParameterType[JString](name, default, required, validators)

  case Integer(name: ParameterName,
               default: Option[Int] = None,
               required: scala.Boolean = false,
               options: List[(JString, Int)] = List(),
               maxLength: Option[Int] = None,
               placeholder: Option[Int] = None,
               thousandSeparator: Option[JString] = None,
               allowNegative: Option[scala.Boolean] = None,
               allowPositive: Option[scala.Boolean] = None,
               pattern: Option[JString] = None,
               validators: List[ParameterValidator] = List()) extends ParameterType[Int](name, default, required, validators)

  case IntegerRange(name: ParameterName,
                    default: Option[(Int, Int)] = None,
                    required: scala.Boolean = false,
                    minimumValue: Int = 0,
                    maximumValue: Int = 100,
                    validators: List[ParameterValidator] = List()) extends ParameterType[(Int, Int)](name, default, required, validators)

  case IPAddress(name: ParameterName,
                 default: Option[JString] = None,
                 required: scala.Boolean = false,
                 port: scala.Boolean = false,
                 portDefault: Option[scala.Long] = None,
                 options: List[(JString, JString)] = List(),
                 validators: List[ParameterValidator] = List()) extends ParameterType[JString](name, default, required, validators)

  case IPAddressList(name: ParameterName,
                     default: Option[List[JString]] = None,
                     required: scala.Boolean = false,
                     port: scala.Boolean = false,
                     portDefault: Option[Int] = None,
                     options: List[(JString, List[JString])] = List(),
                     validators: List[ParameterValidator] = List()) extends ParameterType[List[JString]](name, default, required, validators)

  case Json(name: ParameterName,
            default: Option[JString] = None,
            required: scala.Boolean = false,
            validators: List[ParameterValidator] = List()) extends ParameterType[JString](name, default, required, validators)

  case Long(name: ParameterName,
            default: Option[scala.Long] = None,
            required: scala.Boolean = false,
            options: List[(JString, scala.Long)] = List(),
            maxLength: Option[Int] = None,
            placeholder: Option[Int] = None,
            thousandSeparator: Option[JString] = None,
            allowNegative: Option[scala.Boolean] = None,
            allowPositive: Option[scala.Boolean] = None,
            pattern: Option[JString] = None,
            validators: List[ParameterValidator] = List()) extends ParameterType[scala.Long](name, default, required, validators)

  case LongRange(name: ParameterName,
                 default: Option[(scala.Long, scala.Long)] = None,
                 required: scala.Boolean = false,
                 minimumValue: scala.Long = 0,
                 maximumValue: scala.Long = 100,
                 validators: List[ParameterValidator] = List()) extends ParameterType[(scala.Long, scala.Long)](name, default, required, validators)

  case Markdown(name: ParameterName,
                default: Option[JString] = None,
                required: scala.Boolean = false,
                validators: List[ParameterValidator] = List()) extends ParameterType[JString](name, default, required, validators)

  case Money(name: ParameterName,
             default: Option[BigDecimal] = None,
             required: scala.Boolean = false,
             options: List[BigDecimal] = List(),
             validators: List[ParameterValidator] = List()) extends ParameterType[BigDecimal](name, default, required, validators)

  case NewPassword(name: ParameterName,
                   default: Option[JString] = None,
                   required: scala.Boolean = false,
                   validators: List[ParameterValidator] = List()) extends ParameterType[JString](name, default, required, validators)

  case Password(name: ParameterName,
                default: Option[JString] = None,
                required: scala.Boolean = false,
                validators: List[ParameterValidator] = List()) extends ParameterType[JString](name, default, required, validators)

  case SearchQuery(name: ParameterName,
                   default: Option[JString] = None,
                   required: scala.Boolean = false,
                   validators: List[ParameterValidator] = List()) extends ParameterType[JString](name, default, required, validators)

  case String(name: ParameterName,
              default: Option[JString] = None,
              required: scala.Boolean = false,
              options: List[(JString, JString)] = List(),
              placeholder: Option[JString] = None,
              maxLength: Option[Int] = None,
              multiLine: scala.Boolean = false,
              inputFormat: Option[JString] = None,
              pattern: Option[JString] = None,
              validators: List[ParameterValidator] = List()) extends ParameterType[JString](name, default, required, validators)

  case StringList(name: ParameterName,
                  default: Option[List[JString]] = None,
                  required: scala.Boolean = false,
                  options: List[(JString, List[JString])] = List(),
                  maxLength: Option[Int] = None,
                  multiLine: scala.Boolean = false,
                  inputFormat: Option[JString] = None,
                  pattern: Option[JString] = None,
                  validators: List[ParameterValidator] = List()) extends ParameterType[List[JString]](name, default, required, validators)

  case StringMap(name: ParameterName,
                 default: Option[Map[JString, JString]] = None,
                 required: scala.Boolean = false,
                 options: Map[JString, JString] = Map(),
                 inputFormat: Option[JString] = None,
                 pattern: Option[JString] = None,
                 validators: List[ParameterValidator] = List()) extends ParameterType[Map[JString, JString]](name, default, required, validators)

  case Time(name: ParameterName,
            default: Option[Instant] = None,
            required: scala.Boolean = false,
            validators: List[ParameterValidator] = List()) extends ParameterType[Instant](name, default, required, validators)

  case TimeZone(name: ParameterName,
                default: Option[JString] = None,
                required: scala.Boolean = false,
                validators: List[ParameterValidator] = List()) extends ParameterType[JString](name, default, required, validators)

  case Uri(name: ParameterName,
           default: Option[URI] = None,
           required: scala.Boolean = false,
           pattern: Option[JString] = None,
           validators: List[ParameterValidator] = List()) extends ParameterType[URI](name, default, required, validators)

  case User(name: ParameterName,
            default: Option[JString] = None,
            required: scala.Boolean = false,
            validators: List[ParameterValidator] = List()) extends ParameterType[JString](name, default, required, validators)

  case Video(name: ParameterName,
             default: Option[JString] = None,
             required: scala.Boolean = false,
             validators: List[ParameterValidator] = List()) extends ParameterType[JString](name, default, required, validators)

object ParameterType:
  val title = Parameter.String("title")
  val description = Parameter.String("description")
  val tags = Parameter.StringList("tags")