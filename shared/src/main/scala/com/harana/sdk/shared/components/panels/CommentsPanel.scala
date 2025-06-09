package com.harana.sdk.shared.components.panels

import com.harana.sdk.shared.models.common.{Comment, Component, User}
import io.circe.{Decoder, Encoder, Json}

case class CommentsPanel(comments: List[Comment],
                         loggedInUser: User,
                         allowVoting: Boolean,
                         allowReplies: Boolean) extends Component derives Decoder, Encoder