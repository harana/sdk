package com.harana.sdk.shared.models.common

import com.harana.sdk.shared.utils.CirceCodecs.*
import com.harana.sdk.shared.models.common.{DateTimeStyle, ParameterValidator}
import com.harana.sdk.shared.models.data.ConnectionType
import org.latestbit.circe.adt.codec.JsonTaggedAdt

import java.net.URI
import java.time.Instant
import scala.collection.mutable
import java.lang.String as JString

type ParameterName = String
type ParameterValues = Map[ParameterName, ?]

enum Parameter[A](
                   val name: JString,
                   val default: Option[A],
                   val required: scala.Boolean,
                   val validators: List[ParameterValidator]
                 ) derives JsonTaggedAdt.Decoder, JsonTaggedAdt.Encoder:
  case Boolean(
                override val name: JString,
                override val default: Option[scala.Boolean] = None,
                override val required: scala.Boolean = false,
                override val validators: List[ParameterValidator] = List()
              ) extends Parameter[scala.Boolean](name, default, required, validators)

  case Code(
             override val name: JString,
             override val default: Option[JString] = None,
             override val required: scala.Boolean = false,
             override val validators: List[ParameterValidator] = List()
           ) extends Parameter[JString](name, default, required, validators)

  case Color(
              override val name: JString,
              override val default: Option[JString] = None,
              override val required: scala.Boolean = false,
              override val validators: List[ParameterValidator] = List()
            ) extends Parameter[JString](name, default, required, validators)

  case Connection(
                   override val name: JString,
                   connectionType: ConnectionType,
                   override val default: Option[JString] = None,
                   override val required: scala.Boolean = false,
                   override val validators: List[ParameterValidator] = List()
                 ) extends Parameter[JString](name, default, required, validators)

  case Country(
                override val name: JString,
                override val default: Option[JString] = None,
                override val required: scala.Boolean = false,
                override val validators: List[ParameterValidator] = List()
              ) extends Parameter[JString](name, default, required, validators)

  case DataTable(
                  override val name: JString,
                  override val default: Option[JString] = None,
                  override val required: scala.Boolean = false,
                  override val validators: List[ParameterValidator] = List()
                ) extends Parameter[JString](name, default, required, validators)

  case Date(
             override val name: JString,
             override val default: Option[Instant] = None,
             override val required: scala.Boolean = false,
             override val validators: List[ParameterValidator] = List()
           ) extends Parameter[Instant](name, default, required, validators)

  case DateRange(
                  override val name: JString,
                  override val default: Option[(Instant, Instant)] = None,
                  override val required: scala.Boolean = false,
                  override val validators: List[ParameterValidator] = List()
                ) extends Parameter[(Instant, Instant)](name, default, required, validators)

  case DateTime(
                 override val name: JString,
                 override val default: Option[Instant] = None,
                 override val required: scala.Boolean = false,
                 dateStyle: DateTimeStyle = DateTimeStyle.Short,
                 timeStyle: DateTimeStyle = DateTimeStyle.Short,
                 dateOptions: List[Instant] = List(),
                 override val validators: List[ParameterValidator] = List()
               ) extends Parameter[Instant](name, default, required, validators)

  case Decimal(
                override val name: JString,
                override val default: Option[BigDecimal] = None,
                override val required: scala.Boolean = false,
                options: List[JString] = List(),
                maxLength: Option[Int] = None,
                placeholder: Option[JString] = None,
                decimalSeparator: Option[JString] = None,
                thousandSeparator: Option[JString] = None,
                allowNegative: Option[scala.Boolean] = None,
                allowPositive: Option[scala.Boolean] = None,
                pattern: Option[JString] = None,
                override val validators: List[ParameterValidator] = List()
              ) extends Parameter[BigDecimal](name, default, required, validators)

  case DecimalRange(
                     override val name: JString,
                     override val default: Option[(BigDecimal, BigDecimal)] = None,
                     override val required: scala.Boolean = false,
                     minimumValue: BigDecimal = 0,
                     maximumValue: BigDecimal = 100,
                     override val validators: List[ParameterValidator] = List()
                   ) extends Parameter[(BigDecimal, BigDecimal)](name, default, required, validators)

  case Email(
              override val name: JString,
              override val default: Option[JString] = None,
              override val required: scala.Boolean = false,
              pattern: Option[JString] = None,
              override val validators: List[ParameterValidator] = List()
            ) extends Parameter[JString](name, default, required, validators)

  case Emoji(
              override val name: JString,
              override val default: Option[JString] = None,
              override val required: scala.Boolean = false,
              override val validators: List[ParameterValidator] = List()
            ) extends Parameter[JString](name, default, required, validators)

  case File(
             override val name: JString,
             override val default: Option[JString] = None,
             override val required: scala.Boolean = false,
             allowDirectories: scala.Boolean = false,
             allowFiles: scala.Boolean = true,
             override val validators: List[ParameterValidator] = List()
           ) extends Parameter[JString](name, default, required, validators)

  case GeoAddress(
                   override val name: JString,
                   override val default: Option[JString] = None,
                   override val required: scala.Boolean = false,
                   override val validators: List[ParameterValidator] = List()
                 ) extends Parameter[JString](name, default, required, validators)

  case GeoCoordinate(
                      override val name: JString,
                      override val default: Option[(Double, Double)] = None,
                      override val required: scala.Boolean = false,
                      override val validators: List[ParameterValidator] = List()
                    ) extends Parameter[(Double, Double)](name, default, required, validators)

  case GeoLocation(
                    override val name: JString,
                    override val default: Option[(Double, Double)] = None,
                    override val required: scala.Boolean = false,
                    override val validators: List[ParameterValidator] = List()
                  ) extends Parameter[(Double, Double)](name, default, required, validators)

  case Html(
             override val name: JString,
             override val default: Option[JString] = None,
             override val required: scala.Boolean = false,
             override val validators: List[ParameterValidator] = List()
           ) extends Parameter[JString](name, default, required, validators)

  case Image(
              override val name: JString,
              override val default: Option[JString] = None,
              override val required: scala.Boolean = false,
              override val validators: List[ParameterValidator] = List()
            ) extends Parameter[JString](name, default, required, validators)

  case Integer(
                override val name: JString,
                override val default: Option[Int] = None,
                override val required: scala.Boolean = false,
                options: List[(JString, Int)] = List(),
                maxLength: Option[Int] = None,
                placeholder: Option[Int] = None,
                thousandSeparator: Option[JString] = None,
                allowNegative: Option[scala.Boolean] = None,
                allowPositive: Option[scala.Boolean] = None,
                pattern: Option[JString] = None,
                override val validators: List[ParameterValidator] = List()
              ) extends Parameter[Int](name, default, required, validators)

  case IntegerRange(
                     override val name: JString,
                     override val default: Option[(Int, Int)] = None,
                     override val required: scala.Boolean = false,
                     minimumValue: Int = 0,
                     maximumValue: Int = 100,
                     override val validators: List[ParameterValidator] = List()
                   ) extends Parameter[(Int, Int)](name, default, required, validators)

  case IPAddress(
                  override val name: JString,
                  override val default: Option[JString] = None,
                  override val required: scala.Boolean = false,
                  port: scala.Boolean = false,
                  portDefault: Option[scala.Long] = None,
                  options: List[(JString, JString)] = List(),
                  override val validators: List[ParameterValidator] = List()
                ) extends Parameter[JString](name, default, required, validators)

  case IPAddressList(
                      override val name: JString,
                      override val default: Option[List[JString]] = None,
                      override val required: scala.Boolean = false,
                      port: scala.Boolean = false,
                      portDefault: Option[Int] = None,
                      options: List[(JString, List[JString])] = List(),
                      override val validators: List[ParameterValidator] = List()
                    ) extends Parameter[List[JString]](name, default, required, validators)

  case Json(
             override val name: JString,
             override val default: Option[JString] = None,
             override val required: scala.Boolean = false,
             override val validators: List[ParameterValidator] = List()
           ) extends Parameter[JString](name, default, required, validators)

  case Long(
             override val name: JString,
             override val default: Option[scala.Long] = None,
             override val required: scala.Boolean = false,
             options: List[(JString, scala.Long)] = List(),
             maxLength: Option[Int] = None,
             placeholder: Option[Int] = None,
             thousandSeparator: Option[JString] = None,
             allowNegative: Option[scala.Boolean] = None,
             allowPositive: Option[scala.Boolean] = None,
             pattern: Option[JString] = None,
             override val validators: List[ParameterValidator] = List()
           ) extends Parameter[scala.Long](name, default, required, validators)

  case LongRange(
                  override val name: JString,
                  override val default: Option[(scala.Long, scala.Long)] = None,
                  override val required: scala.Boolean = false,
                  minimumValue: scala.Long = 0,
                  maximumValue: scala.Long = 100,
                  override val validators: List[ParameterValidator] = List()
                ) extends Parameter[(scala.Long, scala.Long)](name, default, required, validators)

  case Markdown(
                 override val name: JString,
                 override val default: Option[JString] = None,
                 override val required: scala.Boolean = false,
                 override val validators: List[ParameterValidator] = List()
               ) extends Parameter[JString](name, default, required, validators)

  case Money(
              override val name: JString,
              override val default: Option[BigDecimal] = None,
              override val required: scala.Boolean = false,
              options: List[BigDecimal] = List(),
              override val validators: List[ParameterValidator] = List()
            ) extends Parameter[BigDecimal](name, default, required, validators)

  case NewPassword(
                    override val name: JString,
                    override val default: Option[JString] = None,
                    override val required: scala.Boolean = false,
                    override val validators: List[ParameterValidator] = List()
                  ) extends Parameter[JString](name, default, required, validators)

  case Password(
                 override val name: JString,
                 override val default: Option[JString] = None,
                 override val required: scala.Boolean = false,
                 override val validators: List[ParameterValidator] = List()
               ) extends Parameter[JString](name, default, required, validators)

  case SearchQuery(
                    override val name: JString,
                    override val default: Option[JString] = None,
                    override val required: scala.Boolean = false,
                    override val validators: List[ParameterValidator] = List()
                  ) extends Parameter[JString](name, default, required, validators)

  case String(
               override val name: JString,
               override val default: Option[JString] = None,
               override val required: scala.Boolean = false,
               options: List[(JString, JString)] = List(),
               placeholder: Option[JString] = None,
               maxLength: Option[Int] = None,
               multiLine: scala.Boolean = false,
               inputFormat: Option[JString] = None,
               pattern: Option[JString] = None,
               override val validators: List[ParameterValidator] = List()
             ) extends Parameter[JString](name, default, required, validators)

  case StringList(
                   override val name: JString,
                   override val default: Option[List[JString]] = None,
                   override val required: scala.Boolean = false,
                   options: List[(JString, List[JString])] = List(),
                   maxLength: Option[Int] = None,
                   multiLine: scala.Boolean = false,
                   inputFormat: Option[JString] = None,
                   pattern: Option[JString] = None,
                   override val validators: List[ParameterValidator] = List()
                 ) extends Parameter[List[JString]](name, default, required, validators)

  case StringMap(
                  override val name: JString,
                  override val default: Option[Map[JString, JString]] = None,
                  override val required: scala.Boolean = false,
                  options: Map[JString, JString] = Map(),
                  inputFormat: Option[JString] = None,
                  pattern: Option[JString] = None,
                  override val validators: List[ParameterValidator] = List()
                ) extends Parameter[Map[JString, JString]](name, default, required, validators)

  case Time(
             override val name: JString,
             override val default: Option[Instant] = None,
             override val required: scala.Boolean = false,
             override val validators: List[ParameterValidator] = List()
           ) extends Parameter[Instant](name, default, required, validators)

  case TimeZone(
                 override val name: JString,
                 override val default: Option[JString] = None,
                 override val required: scala.Boolean = false,
                 override val validators: List[ParameterValidator] = List()
               ) extends Parameter[JString](name, default, required, validators)

  case Uri(
            override val name: JString,
            override val default: Option[URI] = None,
            override val required: scala.Boolean = false,
            pattern: Option[JString] = None,
            override val validators: List[ParameterValidator] = List()
          ) extends Parameter[URI](name, default, required, validators)

  case User(
             override val name: JString,
             override val default: Option[JString] = None,
             override val required: scala.Boolean = false,
             override val validators: List[ParameterValidator] = List()
           ) extends Parameter[JString](name, default, required, validators)

  case Video(
              override val name: JString,
              override val default: Option[JString] = None,
              override val required: scala.Boolean = false,
              override val validators: List[ParameterValidator] = List()
            ) extends Parameter[JString](name, default, required, validators)

object Parameter {
  val title = Parameter.String("title")
  val description = Parameter.String("description")
  val tags = Parameter.StringList("tags")
}