package com.harana.sdk.shared.components.cards

import com.harana.sdk.shared.models.common.{Component, Video}
import io.circe.{Decoder, Encoder}

case class VideoCard(video: Video,
                     showTitle: Boolean,
                     showDescription: Boolean,
                     showPlayTime: Boolean,
                     showDownload: Boolean) extends Component derives Decoder, Encoder
