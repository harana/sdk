package com.harana.sdk.shared.components.cards

import com.harana.sdk.shared.models.common.{Component, Image}
import io.circe.{Decoder, Encoder}

case class ImageCard(image: Image,
                     showTitle: Boolean,
                     showDescription: Boolean,
                     showFileSize: Boolean,
                     showDownload: Boolean) extends Component derives Decoder, Encoder
