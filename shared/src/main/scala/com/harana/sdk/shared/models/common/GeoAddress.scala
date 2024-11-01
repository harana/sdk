package com.harana.sdk.shared.models.common

import io.circe.{Decoder, Encoder}

case class GeoAddress(unitNumber: String,
                      streetNumber: String,
                      streetName: String,
                      streetType: String,
                      postalCode: String,
                      city: String,
                      state: String,
                      country: String) derives Decoder, Encoder
