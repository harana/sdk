package com.harana.sdk.shared.models.features.chronon

import io.circe.generic.JsonCodec

@JsonCodec
case class Collector(operation: Operation,
                     k: Option[Int] = None,
                     percentiles: Option[Array[Double]] = None)

object Collector {
  val approxUniqueCountLgk = Collector(Operation.APPROX_UNIQUE_COUNT)
  val histogramK = Collector(Operation.HISTOGRAM, k = Some(10))
  val approxHistogramK = Collector(Operation.HISTOGRAM, k = Some(10))
  val firstK = Collector(Operation.FIRST, k = Some(5))
  val lastK = Collector(Operation.LAST, k = Some(5))
  val topK = Collector(Operation.HISTOGRAM, k = Some(5))
  val bottomK = Collector(Operation.HISTOGRAM, k = Some(5))
  val approxPercentile = Collector(Operation.APPROX_PERCENTILE, k = Some(128), percentiles = Some(Array(0.25, 0.5, 0.75)))
}