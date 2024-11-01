package com.harana.sdk.shared.components.cards

import com.harana.sdk.shared.models.common.{Component, Question}
import io.circe.{Decoder, Encoder}

case class QuestionCard(question: Question) extends Component derives Decoder, Encoder
