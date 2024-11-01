package com.harana.sdk.shared.models

import com.harana.sdk.shared.models.common.{Parameter}
import enumeratum.{CirceEnum, Enum, EnumEntry}

package object schedules {

  sealed trait ActionCompressionType extends EnumEntry
  case object ActionCompressionType extends Enum[ActionCompressionType] with CirceEnum[ActionCompressionType] {
    case object Bzip2 extends ActionCompressionType
    case object Gzip extends ActionCompressionType
    case object Jar extends ActionCompressionType
    case object Rar extends ActionCompressionType
    case object Tar extends ActionCompressionType
    case object TarGzip extends ActionCompressionType
    case object Xz extends ActionCompressionType
    case object Zip extends ActionCompressionType
    val values = findValues
  }

  val compressionFileTypeParameters = Parameter.String(
    name = "compressionFileType",
    options = List(
      "bzip2" -> "bzip2",
      "gzip" -> "gzip",
      "jar" -> "jar",
      "rar" -> "rar",
      "tar" -> "tar",
      "tarGzip" -> "tarGzip",
      "xz" -> "xz",
      "zip" -> "zip"
    )
  )

  sealed trait ActionFileSource extends EnumEntry
  case object ActionFileSource extends Enum[ActionFileSource] with CirceEnum[ActionFileSource] {
    case object AwsS3 extends ActionFileSource
    case object AzureBs extends ActionFileSource
    case object Ftp extends ActionFileSource
    case object Ftps extends ActionFileSource
    case object Gcs extends ActionFileSource
    case object Harana extends ActionFileSource
    case object Http extends ActionFileSource
    case object Https extends ActionFileSource
    case object Sftp extends ActionFileSource
    case object Smb extends ActionFileSource
    case object WebDav extends ActionFileSource
    val values = findValues
  }

  val fileTypeParameters = Parameter.String(
    name = "fileType",
    options = List(
      "awsS3" -> "awsS3",
      "azureBs" -> "azureBs",
      "ftp" -> "ftp",
      "ftps" -> "ftps",
      "gcs" -> "gcs",
      "harana" -> "harana",
      "http" -> "http",
      "https" -> "https",
      "sftp" -> "sftp",
      "smb" -> "smb",
      "webDav" -> "webDav"
    )
  )

  sealed trait ActionMode extends EnumEntry
  case object ActionMode extends Enum[ActionMode] with CirceEnum[ActionMode] {
    case object Parallel extends ActionMode
    case object Sequential extends ActionMode
    val values = findValues
  }

  sealed trait EventMode extends EnumEntry
  case object EventMode extends Enum[EventMode] with CirceEnum[EventMode] {
    case object All extends EventMode
    case object Any extends EventMode
    val values = findValues
  }

  sealed trait NotifierType extends EnumEntry
  case object NotifierType extends Enum[NotifierType] with CirceEnum[NotifierType] {
    case object Email extends NotifierType
    case object OpsGenie extends NotifierType
    case object PagerDuty extends NotifierType
    case object PushOver extends NotifierType
    case object Slack extends NotifierType
    case object SplunkOnCall extends NotifierType
    case object WebHook extends NotifierType
    case object WeChat extends NotifierType
    val values = findValues
  }
}
