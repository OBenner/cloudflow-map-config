package ru.omyagkov.settings

import cloudflow.streamlets.ConfigParameter

import scala.collection.immutable

trait CustomConfig {
  @transient val myMapConfig: MapConfigParameter = MapConfigParameter(
    "map-config",
    "map-config"
  )

  protected val customSettings: immutable.IndexedSeq[ConfigParameter] =
    Vector(
      myMapConfig
    )

}
