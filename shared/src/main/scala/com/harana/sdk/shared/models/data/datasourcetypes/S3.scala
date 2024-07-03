package com.harana.sdk.shared.models.data.datasourcetypes

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup}
import com.harana.sdk.shared.models.data.DataSourceType

class S3 extends DataSourceType {

  val regionParameter = Parameter.String("region", required = true, options = List(
    ("us-east-1", "us-east-1"),
    ("us-east-2", "us-east-2"),
    ("us-west-1", "us-west-1"),
    ("us-west-2", "us-west-2"),
    ("af-south-1", "af-south-1"),
    ("ap-east-1", "ap-east-1"),
    ("ap-south-1", "ap-south-1"),
    ("ap-northeast-1", "ap-northeast-1"),
    ("ap-northeast-2", "ap-northeast-2"),
    ("ap-northeast-3", "ap-northeast-3"),
    ("ap-southeast-1", "ap-southeast-1"),
    ("ap-southeast-2", "ap-southeast-2"),
    ("ca-central-1", "ca-central-1"),
    ("cn-north-1", "cn-north-1"),
    ("cn-northwest-1", "cn-northwest-1"),
    ("eu-central-1", "eu-central-1"),
    ("eu-west-1", "eu-west-1"),
    ("eu-west-2", "eu-west-2"),
    ("eu-west-3", "eu-west-3"),
    ("eu-south-1", "eu-south-1"),
    ("eu-north-1", "eu-north-1"),
    ("sa-east-1", "sa-east-1"),
    ("me-south-1", "me-south-1"),
    ("us-gov-east-1", "us-gov-east-1"),
    ("us-gov-west-1", "us-gov-west-1")
  ))
  val bucketParameter = Parameter.String("bucket", required = true)
  val accessKeyParameter = Parameter.String("access-key", required = true)
  val secretKeyParameter = Parameter.String("secret-key", required = true)
  val generalGroup = ParameterGroup("general", List(regionParameter, bucketParameter,accessKeyParameter, secretKeyParameter))

  val parameterGroups = List(generalGroup)
}