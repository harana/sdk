package com.harana.sdk.shared.components.lists

import com.harana.sdk.shared.models.common.{Comment, Component}
import io.circe.{Decoder, Encoder, Json}

case class CommentsList(title: String,
                        icon: Option[String] = None,
                        comments: List[Comment] = List.empty) extends Component derives Decoder, Encoder