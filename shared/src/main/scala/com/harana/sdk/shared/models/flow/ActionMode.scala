package com.harana.sdk.shared.models.flow

sealed trait ActionMode

object ActionMode {
  case object Normal extends ActionMode
  case object Streaming extends ActionMode
  case object Incremental extends ActionMode
}