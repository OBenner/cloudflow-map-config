package ru.omyagkov

import cloudflow.flink.{FlinkStreamlet, FlinkStreamletLogic}
import cloudflow.streamlets.{ConfigParameter, StreamletShape}
import ru.omyagkov.settings.CustomConfig

import scala.collection.immutable

trait StreamletBase
    extends FlinkStreamlet

    with CustomConfig
{

  @transient override val shape: StreamletShape             = StreamletShape.createEmpty()
  override protected def createLogic(): FlinkStreamletLogic = new StreamletLogic(this)
}

class Streamlet extends StreamletBase {
  override def configParameters: immutable.IndexedSeq[ConfigParameter] =
    customSettings
}
