package com.harana.sdk.shared.components.cards

import com.harana.sdk.shared.models.catalog.Page
import com.harana.sdk.shared.models.common.Component
import io.circe.{Decoder, Encoder, Json}

case class PageCard(page: Page,
                    showTitle: Boolean,
                    showSocial: Boolean,
                    showMessaging: Boolean,
                    value: String) extends Component derives Decoder, Encoder
