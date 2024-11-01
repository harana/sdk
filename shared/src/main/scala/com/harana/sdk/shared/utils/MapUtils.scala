import scala.deriving.*
import scala.compiletime.*
import scala.quoted.*
import scala.reflect.ClassTag

object MapUtils:
  inline def from[T](args: Map[String, Any])(using Mirror.Of[T]): T =
    inline erasedValue[T] match
      case _: Product =>
        val mirror = summon[Mirror.Of[T]]
        inline mirror match
          case prod: Mirror.ProductOf[T] =>
            val elements = getElements[prod.MirroredElemLabels, prod.MirroredElemTypes](args)
            prod.fromProduct(new Product {
              def canEqual(that: Any): Boolean = true
              def productArity: Int = elements.length
              def productElement(n: Int): Any = elements(n)
            })

  private inline def getElements[L <: Tuple, T <: Tuple](args: Map[String, Any]): Array[Any] =
    inline erasedValue[L] match
      case _: EmptyTuple => Array.empty
      case _: (h *: t) =>
        val label = constValue[Tuple.Head[L]].asInstanceOf[String]
        val value = args(label)
        Array(value) ++ getElements[Tuple.Tail[L], Tuple.Tail[T]](args)

  def from(cc: Product): Map[String, Any] =
    cc.getClass.getDeclaredFields.foldLeft(Map.empty[String, Any]) { (acc, field) =>
      field.setAccessible(true)
      acc + (field.getName -> field.get(cc))
    }

  def optionFields[T <: Product](using ct: ClassTag[T]): List[String] =
    ct.runtimeClass.getDeclaredFields
      .filter(_.getType.getSimpleName == "Option")
      .map(_.getName)
      .toList
