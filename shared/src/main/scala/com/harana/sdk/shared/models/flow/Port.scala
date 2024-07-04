package com.harana.sdk.shared.models.flow

sealed trait Port {
  val name: String
}

object Port {
  case class DataFrame(name: String) extends Port
  case class DataFrameList(name: String) extends Port
  case class File(name: String) extends Port
  case class FileList(name: String) extends Port
  case class Int(name: String) extends Port
  case class IntList(name: String) extends Port
  case class RDD(name: String) extends Port
  case class RDDList(name: String) extends Port
}