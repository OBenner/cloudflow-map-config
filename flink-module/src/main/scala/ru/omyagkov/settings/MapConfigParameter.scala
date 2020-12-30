package ru.omyagkov.settings

import cloudflow.streamlets.{ConfigParameter, RegexpValidationType, StreamletContext}
import cloudflow.streamlets.descriptors.ConfigParameterDescriptor
import com.typesafe.config.{ ConfigObject, ConfigValue}

import java.util.Map.Entry
import scala.collection.JavaConverters._

object MapConfigParameter {
  def create(key: String, description: String): MapConfigParameter =
    MapConfigParameter(key, description, None)
}

case class MapConfigParameter(
                               key: String,
                               description: String = "",
                               defaultValue: Option[Map[String, Int]] = None)
  extends ConfigParameter {
  private val customValidation = RegexpValidationType(".*")
  override def toDescriptor: ConfigParameterDescriptor =
    ConfigParameterDescriptor(key, description, customValidation, defaultValue)

  def getValue(context: StreamletContext): Map[String, Int] = {
    println("!!!!!!!!!!!!!! + " + context.streamletConfig)
    context.streamletConfig.getConfig("map-config")
      .entrySet()
      .asScala
      .map(entry => entry.getKey -> entry.getValue.unwrapped().toString.toInt)
      .toMap
  }

  def value(implicit context: StreamletContext): Map[String, Int] =
    getValue(context)

  def withDefaultValue(value: Map[String, Int]): MapConfigParameter =
    this.copy(defaultValue = Some(value))
}
