package com.harana.sdk.shared.models.common

import io.circe.{Decoder, Encoder, Json}

import java.time.Instant
import java.util.regex.Pattern
import scala.reflect.ClassTag
import scala.util.Try

trait ParameterValidator:
  def validate[A](value: A): Option[String]

case class CompositeValidator(validators: List[ParameterValidator]) extends ParameterValidator:
  def validate[A](value: A): Option[String] =
    validators.flatMap(_.validate(value)).headOption

case object RequiredValidator extends ParameterValidator:
  def validate[A](value: A): Option[String] =
    Option(value) match
      case None | Some(null) => Some("Value is required")
      case Some("") if value.isInstanceOf[String] => Some("Value is required")
      case _ => None

object StringValidators:
  case class MinLength(length: Int) extends ParameterValidator:
    def validate[A](value: A): Option[String] =
      value match
        case s: String if s.length < length => Some(s"Must be at least $length characters long")
        case _: String => None
        case _ => Some("Value must be a string")

  case class MaxLength(length: Int) extends ParameterValidator:
    def validate[A](value: A): Option[String] =
      value match
        case s: String if s.length > length => Some(s"Must be at most $length characters long")
        case _: String => None
        case _ => Some("Value must be a string")

  case class PatternValidator(regex: String, message: String = "Invalid format") extends ParameterValidator:
    private val pattern = java.util.regex.Pattern.compile(regex)
    def validate[A](value: A): Option[String] =
      value match
        case s: String if !pattern.matcher(s).matches => Some(message)
        case _: String => None
        case _ => Some("Value must be a string")

  case class EmailValidator() extends ParameterValidator:
    private val emailRegex = """^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$"""
    private val pattern = PatternValidator(emailRegex, "Invalid email format")
    def validate[A](value: A): Option[String] = pattern.validate(value)

// Numeric validators
object NumericValidators:
  case class MinValue[N: Numeric](min: N) extends ParameterValidator:
    def validate[A](value: A): Option[String] =
      value match
        case n: N =>
          val num = summon[Numeric[N]]
          if num.lt(n, min) then Some(s"Must be greater than or equal to $min")
          else None
        case _ => Some(s"Value must be a number of type ${min.getClass.getSimpleName}")

  case class MaxValue[N: Numeric](max: N) extends ParameterValidator:
    def validate[A](value: A): Option[String] =
      value match
        case n: N =>
          val num = summon[Numeric[N]]
          if num.gt(n, max) then Some(s"Must be less than or equal to $max")
          else None
        case _ => Some(s"Value must be a number of type ${max.getClass.getSimpleName}")

  case class Range[N: Numeric](min: N, max: N) extends ParameterValidator:
    private val minValidator = MinValue(min)
    private val maxValidator = MaxValue(max)
    def validate[A](value: A): Option[String] =
      minValidator.validate(value).orElse(maxValidator.validate(value))

// Date validators
object DateValidators:
  case class MinDate(min: Instant) extends ParameterValidator:
    def validate[A](value: A): Option[String] =
      value match
        case date: Instant if date.isBefore(min) => Some(s"Must be after ${min}")
        case _: Instant => None
        case _ => Some("Value must be a date")

  case class MaxDate(max: Instant) extends ParameterValidator:
    def validate[A](value: A): Option[String] =
      value match
        case date: Instant if date.isAfter(max) => Some(s"Must be before ${max}")
        case _: Instant => None
        case _ => Some("Value must be a date")

  case class DateRange(min: Instant, max: Instant) extends ParameterValidator:
    private val minValidator = MinDate(min)
    private val maxValidator = MaxDate(max)
    def validate[A](value: A): Option[String] =
      minValidator.validate(value).orElse(maxValidator.validate(value))

// Collection validators
object CollectionValidators:
  case class MinSize(size: Int) extends ParameterValidator:
    def validate[A](value: A): Option[String] =
      value match
        case c: Iterable[?] if c.size < size => Some(s"Must contain at least $size elements")
        case _: Iterable[?] => None
        case _ => Some("Value must be a collection")

  case class MaxSize(size: Int) extends ParameterValidator:
    def validate[A](value: A): Option[String] =
      value match
        case c: Iterable[?] if c.size > size => Some(s"Must contain at most $size elements")
        case _: Iterable[?] => None
        case _ => Some("Value must be a collection")

// Custom validator creation helper
object ParameterValidator:
  given Decoder[ParameterValidator] = Decoder.decodeString.emap { str => null }
  given Encoder[ParameterValidator] = Encoder.encodeString.contramap[ParameterValidator](_.toString)

  def custom[A <: AnyRef : ClassTag](f: A => Boolean, errorMsg: String): ParameterValidator =
    new ParameterValidator:
      def validate[B](value: B): Option[String] =
        value match
          case v: A =>
            if f(v) then None
            else Some(errorMsg)
          case _ =>
            Some(s"Invalid type: expected ${scala.reflect.classTag[A].runtimeClass.getSimpleName}")

// Factory methods for common validator combinations
object Validators:
  def required: ParameterValidator = RequiredValidator

  def string(minLength: Option[Int] = None,
             maxLength: Option[Int] = None,
             pattern: Option[String] = None): ParameterValidator =
    CompositeValidator(
      List(
        minLength.map(m => StringValidators.MinLength(m)),
        maxLength.map(m => StringValidators.MaxLength(m)),
        pattern.map(p => StringValidators.PatternValidator(p))
      ).flatten
    )

  def numeric[N: Numeric](min: Option[N] = None,
                          max: Option[N] = None): ParameterValidator =
    CompositeValidator(
      List(
        min.map(m => NumericValidators.MinValue(m)),
        max.map(m =>NumericValidators.MaxValue(m))
      ).flatten
    )

  def dateRange(min: Option[Instant] = None,
                max: Option[Instant] = None): ParameterValidator =
    CompositeValidator(
      List(
        min.map(m => DateValidators.MinDate(m)),
        max.map(m => DateValidators.MaxDate(m))
      ).flatten
    )

  def collection(minSize: Option[Int] = None,
                 maxSize: Option[Int] = None): ParameterValidator =
    CompositeValidator(
        List(
          minSize.map(m => CollectionValidators.MinSize(m)),
          maxSize.map(m => CollectionValidators.MaxSize(m))
        ).flatten
    )

  def email: ParameterValidator = StringValidators.EmailValidator()