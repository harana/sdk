package com.harana.sdk.shared.models.data.connection_types

import com.harana.sdk.shared.models.common.{Parameter, ParameterGroup, ParameterValue}
import com.harana.sdk.shared.models.data.ConnectionType

class S3 extends ConnectionType {

  val regionParameter = Parameter.String("region", required = true, options = List(
    ("us-east-1", ParameterValue.String("us-east-1")),
    ("us-east-2", ParameterValue.String("us-east-2")),
    ("us-west-1", ParameterValue.String("us-west-1")),
    ("us-west-2", ParameterValue.String("us-west-2")),
    ("af-south-1", ParameterValue.String("af-south-1")),
    ("ap-east-1", ParameterValue.String("ap-east-1")),
    ("ap-south-1", ParameterValue.String("ap-south-1")),
    ("ap-northeast-1", ParameterValue.String("ap-northeast-1")),
    ("ap-northeast-2", ParameterValue.String("ap-northeast-2")),
    ("ap-northeast-3", ParameterValue.String("ap-northeast-3")),
    ("ap-southeast-1", ParameterValue.String("ap-southeast-1")),
    ("ap-southeast-2", ParameterValue.String("ap-southeast-2")),
    ("ca-central-1", ParameterValue.String("ca-central-1")),
    ("cn-north-1", ParameterValue.String("cn-north-1")),
    ("cn-northwest-1", ParameterValue.String("cn-northwest-1")),
    ("eu-central-1", ParameterValue.String("eu-central-1")),
    ("eu-west-1", ParameterValue.String("eu-west-1")),
    ("eu-west-2", ParameterValue.String("eu-west-2")),
    ("eu-west-3", ParameterValue.String("eu-west-3")),
    ("eu-south-1", ParameterValue.String("eu-south-1")),
    ("eu-north-1", ParameterValue.String("eu-north-1")),
    ("sa-east-1", ParameterValue.String("sa-east-1")),
    ("me-south-1", ParameterValue.String("me-south-1")),
    ("us-gov-east-1", ParameterValue.String("us-gov-east-1")),
    ("us-gov-west-1", ParameterValue.String("us-gov-west-1"))
  ))
  val bucketParameter = Parameter.String("bucket", required = true)
  val accessKeyParameter = Parameter.String("access-key", required = true)
  val secretKeyParameter = Parameter.String("secret-key", required = true)
  val generalGroup = ParameterGroup("general", List(regionParameter, bucketParameter,accessKeyParameter, secretKeyParameter))

  val parameterGroups = List(generalGroup)
}