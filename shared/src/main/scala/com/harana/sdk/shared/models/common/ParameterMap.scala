package com.harana.sdk.shared.models.common

import io.circe.*
import io.circe.syntax.*

import scala.collection.immutable.HashMap
import scala.collection.mutable

// Case class for storing parameter values with their types
case class ParameterValue[T](value: T, parameter: Parameter[T])

// Type-safe parameter map implementation
class ParameterMap:
  private val values = mutable.Map[String, ParameterValue[?]]()

  def put[T](param: Parameter[T], value: T): Either[String, Unit] =
    // Run validators
    val validationErrors = param.validators.flatMap(validator =>
      validator.validate(value)
    )

    if validationErrors.nonEmpty then
      Left(validationErrors.mkString(", "))
    else
      values(param.name) = ParameterValue(value, param)
      Right(())

  def get[T](param: Parameter[T]): Option[T] =
    values.get(param.name).collect {
      case ParameterValue(v, p) if p == param => v.asInstanceOf[T]
    }

  def getOrDefault[T](param: Parameter[T]): T =
    get(param).orElse(param.default).getOrElse(
      throw new NoSuchElementException(s"No value or default found for parameter: ${param.name}")
    )

  def contains(param: Parameter[?]): Boolean =
    values.contains(param.name)

  def remove[T](param: Parameter[T]): Option[T] =
    values.remove(param.name).collect {
      case ParameterValue(v, p) if p == param => v.asInstanceOf[T]
    }

  def clear(): Unit = values.clear()

  def isEmpty: Boolean = values.isEmpty

  def nonEmpty: Boolean = values.nonEmpty

  def size: Int = values.size

  def parameters: Set[Parameter[?]] =
    values.values.map(_.parameter).toSet

  def validate(): List[String] =
    values.values.flatMap { paramValue =>
      val param = paramValue.parameter

      // Check required fields
      val requiredError =
        if param.required && paramValue.value == null then
          Some(s"Required parameter ${param.name} is null")
        else None

      // Run all validators
      val validationErrors = param.validators.flatMap(validator =>
        validator.validate(paramValue.value)
      )

      requiredError.toList ++ validationErrors
    }.toList

  def toMap: Map[String, Any] =
    values.view.mapValues(_.value).toMap