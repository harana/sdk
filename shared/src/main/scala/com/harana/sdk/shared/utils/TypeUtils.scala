package com.harana.sdk.shared.utils

import com.harana.sdk.shared.models.flow.ActionTypeInfo
import izumi.reflect.Tag
import com.harana.sdk.utils.ReflectUtils

object TypeUtils {

  def actionType[T <: ActionTypeInfo](typeTag: Tag[T]): T = {
    val name = "com.harana.sdk.shared.models.flow.catalog." + typeTag.closestClass.getSimpleName
    ReflectUtils.classForName[T](name.substring(0, name.length - 4))
  }

}