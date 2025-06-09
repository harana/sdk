package com.harana.sdk.shared.components.lists

import com.harana.sdk.shared.models.common.{Component, File}
import io.circe.{Decoder, Encoder, Json}


case class FilesList(title: String,
                     icon: String,
                     files: List[File] = List.empty,
                     showDownload: Boolean = false,
                     showFileSize: Boolean = false,
                     showOwner: Boolean = false)
  extends Component derives Decoder, Encoder
