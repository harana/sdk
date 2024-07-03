package com.harana.sdk.shared.models.flow

sealed trait Port {
  type A
  val name: String
}

object Port {

  case class DataFrame(name: String) extends Port {
    type A = org.apache.spark.sql.DataFrame
  }

  case class DataFrameList(name: String) extends Port {
    type A = List[org.apache.spark.sql.DataFrame]
  }

  case class File(name: String) extends Port {
    type A = File
  }

  case class FileList(name: String) extends Port {
    type A = List[File]
  }

  case class Int(name: String) extends Port {
    type A = Int
  }

  case class IntList(name: String) extends Port {
    type A = List[Int]
  }

  case class RDD(name: String) extends Port {
    type A = RDD
  }

  case class RDDList(name: String) extends Port {
    type A = List[RDD]
  }
}